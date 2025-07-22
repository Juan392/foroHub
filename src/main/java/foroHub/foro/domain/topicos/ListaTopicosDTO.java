package foroHub.foro.domain.topicos;

import java.time.LocalDateTime;
import java.util.Date;

public record ListaTopicosDTO(
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        boolean status,
        String autor,
        String curso
) {

    public ListaTopicosDTO(Topicos datos) {
        this(
                datos.getTitulo(),
                datos.getMensaje(),
                datos.getFechaDeCreacion(),
                datos.isStatus(),
                datos.getAutor(),
                datos.getCurso()
        );
    }
}
