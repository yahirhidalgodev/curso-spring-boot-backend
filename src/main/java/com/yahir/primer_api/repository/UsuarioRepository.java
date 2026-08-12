package com.yahir.primer_api.repository;

import com.yahir.primer_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);

    Usuario findByNombreAndEdad(String nombre, Integer edad);

    List<Usuario> findByEdadGreaterThanEqual(Integer edad);

    List<Usuario> findByEdadBetween(Integer edadAfter, Integer edadBefore);

    List<Usuario> findByOrderByEdadAsc();

    List<Usuario> findByEdadGreaterThanEqualOrderByEdadDesc(Integer edad);
}

