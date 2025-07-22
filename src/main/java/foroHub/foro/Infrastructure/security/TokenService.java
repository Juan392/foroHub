package foroHub.foro.Infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import foroHub.foro.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${foro.security.token.secret}")
    private String secret;

    public String generarToken(Usuario usuario) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("foro_hub").withSubject(usuario.getLogin())
                    .withExpiresAt(fechaDeExpiramiento()).sign(algorithm);

        }catch (JWTCreationException exception){
            throw new RuntimeException("Error al obtener el token");
        }
    }

    private Instant fechaDeExpiramiento() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }

    public String getSubject(String TokenJWT) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        try {
            return JWT.require(algorithm).withIssuer("foro_hub")
                    .build()
                    .verify(TokenJWT)
                    .getSubject();
        }catch (JWTCreationException exception){
            throw new RuntimeException("TokenJWT invalido");
        }
    }
}
