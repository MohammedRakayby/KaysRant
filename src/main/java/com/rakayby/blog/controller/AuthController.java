package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.model.AuthRequest;
import com.rakayby.blog.model.Response;
import com.rakayby.blog.model.UserProfile;
import com.rakayby.blog.util.CookieUtils;
import com.rakayby.blog.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.AUTH_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserUtils userUtils;
    private final CookieUtils cookieUtils;

    @PostMapping(ApiEndPoints.AuthController.LOGIN)
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            SecurityContextHolder.getContext().setAuthentication(
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
            );
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.SET_COOKIE, cookieUtils.deleteAccessTokenCookie().toString());
            return ResponseEntity.ok()
                    .headers(httpHeaders)
                    .body(new Response.Builder()
                            .withMessage("Invalid username or password")
                            .withHttpStatus(HttpStatus.FORBIDDEN)
                            .withStatus(Boolean.FALSE).build());
        }
        final UserProfile profile = userUtils.createProfileFromUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.SET_COOKIE, cookieUtils.createAccessTokenCookie(profile.getUsername()).toString());
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(new Response.Builder()
                        .withMessage("Authenticated")
                        .withHttpStatus(HttpStatus.OK)
                        .withData(profile.getUsername())
                        .withStatus(Boolean.TRUE).build());
    }

    @GetMapping(value = ApiEndPoints.AuthController.LOGOUT)
    public ResponseEntity logout() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        SecurityContextHolder.clearContext();
        httpHeaders.add(HttpHeaders.SET_COOKIE, cookieUtils.deleteAccessTokenCookie().toString());
        return ResponseEntity.ok().headers(httpHeaders).body(new Response.Builder().withMessage("Logout successful").withStatus(Boolean.TRUE).build());
    }
}
