package br.com.rsfot.vollmed.infra.security;

import br.com.rsfot.vollmed.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456789");
            return JWT.create()
                    .withIssuer("API Vollmed")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expiresAtTwoHoursAfterLogin())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Instant expiresAtTwoHoursAfterLogin() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
