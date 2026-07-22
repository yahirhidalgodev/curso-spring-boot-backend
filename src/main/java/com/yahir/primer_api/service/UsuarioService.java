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



}