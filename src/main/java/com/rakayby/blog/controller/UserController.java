package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.db.service.UserService;
import com.rakayby.blog.model.Response;
import com.rakayby.blog.model.UserProfile;
import com.rakayby.blog.util.HttpUtils;
import com.rakayby.blog.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.USER_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(ApiEndPoints.GenericEndpoints.CREATE)
    public ResponseEntity create(@RequestBody UserProfile user) {

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Boolean userFetched = this.userService.create(user);
            if (userFetched) {
                final HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add(HttpHeaders.SET_COOKIE,
                        HttpUtils.createAccessTokenCookie(jwtUtils.generateToken(user.getUsername())).toString());
                return ResponseEntity.ok()
                        .headers(httpHeaders)
                        .body(new Response.Builder()
                                .withMessage("Registeration Successful")
//                                .withHttpStatus(HttpStatus.OK)
                                .withStatus(Boolean.TRUE)
                                .build());
            } else {
                return ResponseEntity.ok().body(new Response.Builder()
                        .withMessage("User already created")
//                        .withHttpStatus(HttpStatus.OK)
                        .withStatus(Boolean.FALSE)
                        .build());
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response.Builder().withMessage("Failed, User already exists").withStatus(Boolean.FALSE).build());
        }
    }

//    @GetMapping(value = ApiEndPoints.GenericEndpoints.GET)
//    public ResponseEntity getUser() {
//        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.getName().equals("anonymousUser")) {
//            return ResponseEntity.ok().body(new Response.Builder().withMessage("User is not logged").withStatus(Boolean.FALSE).build());
//        }
//        final User user = userService.loadUserByUsername(auth.getName());
//        return ResponseEntity.ok().body(new Response.Builder()
//                .withMessage("Logged in")
//                .withStatus(Boolean.TRUE)
//                //                .withData(user.getUsername())
//                .build());
//    }
}
