package com.yahir.primer_api.controller;


import com.yahir.primer_api.model.Usuario;
import com.yahir.primer_api.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    //Declarar la dependencia
    private final UsuarioService usuarioService;

    //Constructor para inyectar UsuarioService
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }



}
