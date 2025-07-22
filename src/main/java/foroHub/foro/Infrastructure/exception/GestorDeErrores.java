package foroHub.foro.Infrastructure.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException error) {
        var errores = error.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(datosErrorValidacion::new));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity error403(AccessDeniedException error){
        var errores = error.getMessage();
        return ResponseEntity.ok().body(errores);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacionExcepcion.class)
    public ResponseEntity tratarErrorDeValidaciones(ValidacionExcepcion e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public record datosErrorValidacion(
            String campo,
            String mensaje
    ){
        public datosErrorValidacion(FieldError error){
            this(
                    error.getField(), error.getDefaultMessage()
            );
        }
    }
}

