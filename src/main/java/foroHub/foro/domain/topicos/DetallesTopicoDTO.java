package foroHub.foro.domain.topicos;

import java.time.LocalDateTime;
import java.util.Date;

public record DetallesTopicoDTO(
        Long id,
        String título,
        String mensaje,
        LocalDateTime fechaDeCreación,
        boolean status,
        String autor,
        String curso

) {
    public DetallesTopicoDTO(Topicos datos){
        this(
                datos.getId(), datos.getTitulo(), datos.getMensaje(),datos.getFechaDeCreacion(), datos.isStatus(),datos.getAutor(), datos.getCurso()
        );
    }
}
