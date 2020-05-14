package com.rakayby.blog.filters;

import com.rakayby.blog.constant.Constants;
import com.rakayby.blog.db.facade.UserFacade;
import com.rakayby.blog.model.User;
import com.rakayby.blog.util.JwtUtils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    private final UserFacade userFacade;
    private final JwtUtils jwtUtils;
    
    @Override
    protected void doFilterInternal(HttpServletRequest hsr, HttpServletResponse hsr1, FilterChain fc) throws ServletException, IOException {
        final String authHeader = hsr.getHeader("Authorization");
        String jwt = null;
        String userName = null;
        if (authHeader != null) {
            String[] splitHeader = authHeader.split(" ");
            if (splitHeader[0].equals(Constants.BEARER)) {
                jwt = splitHeader[1];
                userName = jwtUtils.extractUsername(jwt);
                //add catch here if the above fails
            }
        }
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userFacade.loadUserByUsername(userName);
            if (jwtUtils.validateToken(jwt, user)) {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(hsr));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        } else {
            //later
        }
        fc.doFilter(hsr, hsr1);
    }
    
}
