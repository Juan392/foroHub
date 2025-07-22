package foroHub.foro.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "topico")
@Table(name = "topicos")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private boolean status;
    private String autor;
    private String curso;

    public Topicos(@Valid RegistroTopicoDTO datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = datos.fechaDeCreacion();
        this.status = true;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarTopico(ActualizarTopicoDTO datos) {
        if(datos.titulo() != null)
            this.titulo = datos.titulo();
        if(datos.mensaje() != null)
            this.mensaje = datos.mensaje();
        if(datos.titulo() != null)
            this.curso = datos.curso();
    }


}
