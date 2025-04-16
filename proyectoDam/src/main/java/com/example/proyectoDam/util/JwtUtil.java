package com.example.proyectoDam.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * Clase utilitaria para generar y validar tokens JWT.
 */
@Component
public class JwtUtil {

    private static final String SECRET_KEY = "supersecretaClaveJWT12345678901234567890"; // mínimo 32 bytes
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 horas

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /**
     * Genera un token JWT con el ID del usuario y su rol.
     *
     * @param userId el ID del usuario
     * @param rol el rol del usuario
     * @return el token generado
     */
    public String generateToken(String userId, String rol) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extrae el ID del usuario del token JWT.
     *
     * @param token el token
     * @return el ID del usuario
     */
    public String extractUserId(String token) {
        return getClaims(token).getSubject();
    }

    /**
     * Extrae el rol del usuario desde el token JWT.
     *
     * @param token el token
     * @return el rol del usuario
     */
    public String extractRol(String token) {
        return getClaims(token).get("rol", String.class);
    }

    /**
     * Verifica si el token JWT es válido.
     *
     * @param token el token
     * @return true si es válido, false si no
     */
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
