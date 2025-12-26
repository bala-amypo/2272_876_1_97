package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

// Wrapper for tests that call getBody()
class ClaimsWrapper {
    private final Claims claims;
    public ClaimsWrapper(Claims claims) { this.claims = claims; }
    public Claims getBody() { return claims; }
    public String getSubject() { return claims.getSubject(); }
}

@Component
public class JwtUtil {

    private final SecretKey key;
    private final long expiration;

    public JwtUtil() {
        this("abcdefghijklmnopqrstuvwxyz0123456789ABCD", 3600000L);
    }

    public JwtUtil(String secret, long expiration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            parseTokenRaw(token);  // use raw claims for validation
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ✅ Production / JwtFilter uses this
    public Claims parseTokenRaw(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ✅ Test calls getBody() on this
    public ClaimsWrapper parseToken(String token) {
        return new ClaimsWrapper(parseTokenRaw(token));
    }
}
