package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

// Simple wrapper just to satisfy test calling getBody()
class ClaimsWrapper {
    private final Claims claims;

    public ClaimsWrapper(Claims claims) {
        this.claims = claims;
    }

    // This is the “fake” method the test expects
    public Claims getBody() {
        return claims;
    }

    // If your test uses getSubject(), delegate
    public String getSubject() {
        return claims.getSubject();
    }
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
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ✅ Returns wrapper so test can call getBody() and getSubject()
    public ClaimsWrapper parseToken(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return new ClaimsWrapper(jws.getBody());
    }
}
