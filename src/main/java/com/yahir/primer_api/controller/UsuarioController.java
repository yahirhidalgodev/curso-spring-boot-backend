package com.yahir.primer_api.controller;

import com.yahir.primer_api.dto.UsuarioRequest;
import com.yahir.primer_api.model.Usuario;
import com.yahir.primer_api.service.UsuarioService;

import com.yahir.primer_api.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    //Declarar la dependencia
    private final UsuarioService usuarioService;

    //Constructor para inyectar UsuarioService
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> guardarUsuario(@Validated @RequestBody UsuarioRequest request){
        UsuarioResponse nuevoUsuario = usuarioService.guardarUsuario(request);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }


    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id,@Validated @RequestBody Usuario usuario){
                Optional<Usuario> usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);

                if(usuarioActualizado.isPresent()){
                    return ResponseEntity.ok(usuarioActualizado.get());
                }
                else {
                    return ResponseEntity.notFound().build();
                }
        }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    }



