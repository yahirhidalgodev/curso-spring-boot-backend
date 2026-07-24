package com.yahir.primer_api.service;

import org.springframework.stereotype.Service;
import com.yahir.primer_api.dto.UsuarioRequest;
import com.yahir.primer_api.dto.UsuarioResponse;
import com.yahir.primer_api.exception.ResourceNotFoundException;
import com.yahir.primer_api.mapper.UsuarioMapper;
import com.yahir.primer_api.model.Usuario;
import com.yahir.primer_api.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse guardarUsuario(UsuarioRequest request) {

        Usuario usuario = UsuarioMapper.convertirAEntidad(request);
        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.convertirAResponse(usuario);
    }

    public List<UsuarioResponse> obtenerUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioResponse> respuesta = new ArrayList<>();

        for(Usuario usuario: usuarios){
            respuesta.add(UsuarioMapper.convertirAResponse(usuario));
        }
        return respuesta;
    }

    public UsuarioResponse obtenerUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario no encontrado."));

        return UsuarioMapper.convertirAResponse(usuario);
    }

    public UsuarioResponse actualizarUsuario(Long id, UsuarioRequest request){

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado."));

        UsuarioMapper.actualizarEntidad(usuario, request);

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.convertirAResponse(usuario);
    }

    public boolean eliminarUsuario(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }


}