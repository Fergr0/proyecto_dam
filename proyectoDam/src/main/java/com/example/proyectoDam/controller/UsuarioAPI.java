package com.example.proyectoDam.controller;

import com.example.proyectoDam.model.UsuarioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioAPI {

    ResponseEntity<List<UsuarioDto>> getAllUsuarios();

    ResponseEntity<UsuarioDto> getUsuarioById(String id);

    ResponseEntity<List<UsuarioDto>> findByNombre(String nombre);

    ResponseEntity<List<UsuarioDto>> findByRol(String rol);

    ResponseEntity<UsuarioDto> saveUsuario(UsuarioDto usuarioDto);

    ResponseEntity<UsuarioDto> updateUsuario(String id, UsuarioDto usuarioDto);

    ResponseEntity<Void> deleteUsuario(String id);

    ResponseEntity<Void> deleteAllUsuarios();
}
