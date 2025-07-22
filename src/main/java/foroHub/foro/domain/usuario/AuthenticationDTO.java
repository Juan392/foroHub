package foroHub.foro.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank String login,
        @NotBlank String contrasena
) {
}
