package com.rakayby.blog.util;

import java.time.Duration;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class CookieUtils {

    public HttpCookie createAccessTokenCookie(String jwt) {
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
