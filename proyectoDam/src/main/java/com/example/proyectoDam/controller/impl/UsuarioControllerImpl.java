package com.example.proyectoDam.controller.impl;

import com.example.proyectoDam.controller.UsuarioAPI;
import com.example.proyectoDam.model.UsuarioDto;
import com.example.proyectoDam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControllerImpl implements UsuarioAPI {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<UsuarioDto>> findByNombre(@PathVariable String nombre) {
        List<UsuarioDto> usuarios = usuarioService.findByNombre(nombre);
        return ResponseEntity.ok(usuarios);
    }

    @Override
    @GetMapping("/buscar/rol/{rol}")
    public ResponseEntity<List<UsuarioDto>> findByRol(@PathVariable String rol) {
        List<UsuarioDto> usuarios = usuarioService.findByRol(rol);
        return ResponseEntity.ok(usuarios);
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDto> saveUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioGuardado = usuarioService.save(usuarioDto);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable String id, @RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setId(id);
        UsuarioDto usuarioActualizado = usuarioService.updateUsuario(usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllUsuarios() {
        usuarioService.deleteAllUsuarios();
        return ResponseEntity.noContent().build();
    }
}
