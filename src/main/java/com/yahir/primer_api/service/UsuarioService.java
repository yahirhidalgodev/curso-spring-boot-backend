package com.yahir.primer_api.service;

import com.yahir.primer_api.model.Usuario;
import com.yahir.primer_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> actualizarUsuario(Long id, Usuario datosUsuario){

        Optional<Usuario> usuarioExistente =
                usuarioRepository.findById(id);

        if(usuarioExistente.isPresent()){

            Usuario usuario = usuarioExistente.get();

            usuario.setNombre(datosUsuario.getNombre());
            usuario.setEdad(datosUsuario.getEdad());

            return Optional.of(usuarioRepository.save(usuario));
        }
        return Optional.empty();
    }

    public boolean eliminarUsuario(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }



}