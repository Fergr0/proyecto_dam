package com.example.proyectoDam.service;

import com.example.proyectoDam.model.UsuarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    // Obtener todos los usuarios
    List<UsuarioDto> getAllUsuarios();

    // Buscar un usuario por ID
    Optional<UsuarioDto> getUsuarioById(String id);

    // Buscar usuarios por nombre
    List<UsuarioDto> findByNombre(String nombre);

    // Buscar usuarios por rol
    List<UsuarioDto> findByRol(String rol);

    // Guardar un usuario
    UsuarioDto save(UsuarioDto usuario);

    // Actualizar un usuario
    UsuarioDto updateUsuario(UsuarioDto usuario);

    // Eliminar un usuario por ID
    ResponseEntity deleteUsuario(String id);

    // Eliminar todos los usuarios
    ResponseEntity deleteAllUsuarios();
}
