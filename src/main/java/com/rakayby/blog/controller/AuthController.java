package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.db.facade.UserFacade;
import com.rakayby.blog.model.AuthRequest;
import com.rakayby.blog.model.AuthResponse;
import com.rakayby.blog.model.User;
import com.rakayby.blog.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final UserFacade userFacade;
    private final JwtUtils jwtUtils;
    
    @PostMapping(ApiEndPoints.AuthController.LOGIN)
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            // will be like this for now
//            return ResponseEntity.ok(new AuthResponse("Invalid username or password ", ""));
            return ResponseEntity.ok(new AuthResponse.Builder("").withErrorMessage("Invalid username or password").withHttpStatus(403).build());
        }
        
        User user = userFacade.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtils.generateToken(user);
        return ResponseEntity.ok(new AuthResponse.Builder(jwt).withHttpStatus(200));
    }
}
