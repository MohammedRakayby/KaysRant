package com.rakayby.blog.util;

import com.rakayby.blog.model.User;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
@RequiredArgsConstructor
public class CookieUtils {

    private final JwtUtils jwtUtils;

    public HttpCookie createAccessTokenCookie(String username) {
        final String jwt = jwtUtils.generateToken(username);
        return ResponseCookie.from("jwt", jwt)
                .maxAge(Duration.ofHours(4))
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from("jwt", "").maxAge(0).httpOnly(true).path("/").build();
    }
}
