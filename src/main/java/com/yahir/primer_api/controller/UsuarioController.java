package com.yahir.primer_api.controller;

import com.yahir.primer_api.dto.UsuarioRequest;
import com.yahir.primer_api.service.UsuarioService;

import com.yahir.primer_api.dto.UsuarioResponse;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<UsuarioResponse> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable Long id,@Validated @RequestBody UsuarioRequest request){
        UsuarioResponse usuarioActualizado = usuarioService.actualizarUsuario(id, request);

        return ResponseEntity.ok(usuarioActualizado);
        }

    @GetMapping("/usuarios/buscar")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorNombre(
            @RequestParam String nombre){

        return ResponseEntity.ok(
                usuarioService.obtenerUsuarioPorNombre(nombre)
        );
    }


}



