package foroHub.foro.domain.topicos;

public record ActualizarTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
