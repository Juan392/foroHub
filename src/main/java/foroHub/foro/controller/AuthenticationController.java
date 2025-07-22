package foroHub.foro.controller;

import foroHub.foro.Infrastructure.security.TokenJWTDTO;
import foroHub.foro.Infrastructure.security.TokenService;
import foroHub.foro.domain.usuario.AuthenticationDTO;
import foroHub.foro.domain.usuario.Usuario;
import foroHub.foro.domain.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager manager;
    @Transactional
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var authenticacion = manager.authenticate(authenticationToken);
        var token = tokenService.generarToken((Usuario) authenticacion.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDTO(token));
    }

}
