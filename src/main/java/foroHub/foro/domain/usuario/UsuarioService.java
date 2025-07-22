package foroHub.foro.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registrarUsuario(RegistroUsuariosDTO datos) {
        var passwordEncriptada = passwordEncoder.encode(datos.contrasena());
        var usuario = new Usuario(datos.login(), passwordEncriptada);
        usuarioRepository.save(usuario);
    }
}
