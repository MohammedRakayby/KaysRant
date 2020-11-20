package com.rakayby.blog.util;

import io.jsonwebtoken.Claims;
import java.util.Date;
import java.util.function.Function;

/**
 *
 * @author Rakayby
 */
public interface JwtUtils {

    public String generateToken(String username);

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver);

    public String extractUsername(String token);

    public Date extractExpirationDate(String token);

    public Boolean validateToken(String token, String username);
}
