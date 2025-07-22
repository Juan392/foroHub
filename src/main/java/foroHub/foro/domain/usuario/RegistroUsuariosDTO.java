package foroHub.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroUsuariosDTO(
        @NotBlank @Email String login,
        @NotBlank String contrasena
) {
}
