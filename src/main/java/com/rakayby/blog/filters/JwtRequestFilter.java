package com.rakayby.blog.filters;

import com.rakayby.blog.db.service.UserService;
import com.rakayby.blog.util.JwtUtils;
import io.jsonwebtoken.security.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Mohammed.Rakayby
 */
@RequiredArgsConstructor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final Cookie[] cookies = request.getCookies() != null ? request.getCookies() : null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwt")) {

                    String jwt = cookie.getValue();
                    String userName = null;
                    if (jwt != null) {
                        try {
                            userName = jwtUtils.extractUsername(jwt);
                        } catch (SignatureException e) {
                            SecurityContextHolder.clearContext();
                        }
                    }
                    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        User user = userService.loadUserByUsername(userName);
                        if (jwtUtils.validateToken(jwt, user.getUsername())) {
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(token);
                        } else {
                            SecurityContextHolder.clearContext();
                        }
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}
