package com.bs280.teami.libraries;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.bs280.teami.libraries.interfaces.ITokenization;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtTokenization implements ITokenization {

    private final Key _key;

    public JwtTokenization() {
        this._key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    @Override
    public boolean verify(String token) {
        try {
            // Jws<Claims> claimsJws = Jwts.parserBuilder()
            //         .setSigningKey(Keys.hmacShaKeyFor(this._key))
            //         .build()
            //         .parseClaimsJws(token);

            Jwts.parserBuilder()
                    .setSigningKey(this._key)
                    .build()
                    .parseClaimsJws(token);

            // If the token is successfully parsed and verified, you can access the claims
            // Claims claims = claimsJws.getBody();
            // Perform additional verification or retrieve information from the claims

            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    @Override
    public String sign(TokenizationPayload payload) {     

        Date now = new Date();
        Date expiration = new Date(now.getTime() + 600000); // 10 minutes expiration
   
   
        
        Claims claims = Jwts.claims();
        claims.put("user_id", payload.getId());
        claims.put("username", payload.getUsername());

        // Add more claims as needed

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(this._key)
                .compact();
    }


    @Override
    public String refresh(String token) {
        throw new UnsupportedOperationException("Unimplemented method 'refresh'");
    }

    // private final Key signingKey; // Replace with your own signing key

    // public RefreshTokenService() {
    //     signingKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    // }

    // public String generateRefreshToken(String userId) {
    //     Date now = new Date();
    //     Date expiration = new Date(now.getTime() + 86400000); // 24 hours expiration

    //     return Jwts.builder()
    //             .setSubject(userId)
    //             .setIssuedAt(now)
    //             .setExpiration(expiration)
    //             .signWith(signingKey)
    //             .compact();
    // }

    // public String verifyAndExtractUserId(String refreshToken) {
    //     Claims claims = Jwts.parserBuilder()
    //             .setSigningKey(signingKey)
    //             .build()
    //             .parseClaimsJws(refreshToken)
    //             .getBody();

    //     return claims.getSubject();
    // }
    
}
