package com.yahir.primer_api.mapper;

import com.yahir.primer_api.dto.UsuarioRequest;
import com.yahir.primer_api.dto.UsuarioResponse;
import com.yahir.primer_api.model.Usuario;

public class UsuarioMapper {

    public static Usuario convertirAEntidad(UsuarioRequest request){

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setEdad(request.getEdad());

        return usuario;
    }
    public static UsuarioResponse convertirAResponse(Usuario usuario){
        UsuarioResponse response = new UsuarioResponse();

        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEdad(usuario.getEdad());

        return response;

    }
    public static void actualizarEntidad(Usuario usuario, UsuarioRequest request){
        usuario.setNombre(request.getNombre());
        usuario.setEdad(request.getEdad());
    }

}
