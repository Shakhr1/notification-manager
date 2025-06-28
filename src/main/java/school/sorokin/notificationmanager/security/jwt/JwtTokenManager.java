package school.sorokin.notificationmanager.security.jwt;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Service
@Slf4j
public class JwtTokenManager {

    private final Key secretKey;

    public JwtTokenManager(@Value("${jwt.sign-key}") String secretKey) {
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public boolean isTokenValid(String jwtToken) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parse(jwtToken);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getLoginFromToken(String jwt) {
        log.info("Get login from jwt token = {} ", jwt);
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getPayload()
                .getSubject();
    }

    public String getRoleFromToken(String jwt) {
        log.info("Get role from jwt token = {} ", jwt);
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getPayload()
                .get("role", String.class);
    }
}