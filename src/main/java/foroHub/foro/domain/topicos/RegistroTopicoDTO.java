package foroHub.foro.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.Date;

public record RegistroTopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fechaDeCreacion,
        @NotBlank String autor,
        @NotBlank String curso
) {
}
