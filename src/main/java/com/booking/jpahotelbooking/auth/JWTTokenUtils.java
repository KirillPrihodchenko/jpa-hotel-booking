package com.booking.jpahotelbooking.auth;

import com.booking.jpahotelbooking.exception.InvalidJWTAuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JWTTokenUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expired-time}")
    private int expiredTime;

    public String generateJWTToken(UserDetails userDetails) {

        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        List<String> roles = userDetails.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

        claims.put("Roles", roles);

        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + expiredTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsername(String token) {

        return getAllClaimsFromToken(token)
                .getSubject();
    }

    public List<String> getRoles(String token) {

        return getAllClaimsFromToken(token).get("roles", List.class);
    }

    public boolean validateToken(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);

            return true;
        }
        catch (JwtException | IllegalArgumentException e) {

            throw new InvalidJWTAuthenticationException("Expired or invalid JWT token", e);
        }
    }

    private Claims getAllClaimsFromToken(String token) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}