package com.grupo9.db.security.jwt;

import java.util.Date;

import com.grupo9.db.dto.Auth.JwtDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static String jwtSecret;
    private static int jwtExpirationMs;

    @Value("${digitalBooking.app.jwtSecret}")
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
    @Value("${digitalBooking.app.jwtExpirationMs}")
    public void setJwtExpirationMs(int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .claim("name", userPrincipal.getName())
                .claim("lastname", userPrincipal.getLastname())
                .claim("isActive", userPrincipal.isActive())
                .claim("location", userPrincipal.getLocation())
                .claim("userId", userPrincipal.getId())
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public JwtDto getDecodedJwt(String token) throws BadRequestException {
        try{
            String jwt = token.substring(7);
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody();
            String sub = claims.get("sub").toString();
            Integer iat = Integer.parseInt(claims.get("iat").toString());
            Integer exp = Integer.parseInt(claims.get("exp").toString());
            String name = claims.get("name").toString();
            String lastname = claims.get("lastname").toString();
            Boolean isActive = Boolean.parseBoolean(claims.get("lastname").toString());
            Long userId = Long.parseLong(claims.get("userId").toString());

            return new JwtDto(sub, iat, exp, name, lastname, isActive, userId);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }
}