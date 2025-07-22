package foroHub.foro.controller;

import foroHub.foro.domain.usuario.RegistroUsuariosDTO;
import foroHub.foro.domain.usuario.Usuario;
import foroHub.foro.domain.usuario.UsuarioRepository;
import foroHub.foro.domain.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;
    @Autowired
    UsuarioService usuarioService;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid RegistroUsuariosDTO datos, UriComponentsBuilder uriComponentsBuilder){
        usuarioService.registrarUsuario(datos);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var usuario= repository.getReferenceById(id);
        usuario.eliminarLogico();
        return ResponseEntity.noContent().build();
    }
}
