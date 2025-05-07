package com.example.proyectoDam.controller.impl;

import com.example.proyectoDam.controller.SolicitudAccesoAPI;
import com.example.proyectoDam.model.SolicitudAccesoDto;
import com.example.proyectoDam.service.SolicitudAccesoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes-acceso")
public class SolicitudAccesoControllerImpl implements SolicitudAccesoAPI {

    @Autowired
    private SolicitudAccesoService service;

    @Override
    @GetMapping
    public ResponseEntity<List<SolicitudAccesoDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAccesoDto> getById(@PathVariable String id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<SolicitudAccesoDto>> getByIdUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(service.findByIdUsuario(idUsuario));
    }

    @Override
    @GetMapping("/instalacion/{idInstalacion}")
    public ResponseEntity<List<SolicitudAccesoDto>> getByIdInstalacion(@PathVariable String idInstalacion) {
        return ResponseEntity.ok(service.findByIdInstalacion(idInstalacion));
    }

    @Override
    @PostMapping
    public ResponseEntity<SolicitudAccesoDto> save(@RequestBody SolicitudAccesoDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudAccesoDto> update(@PathVariable String id, @RequestBody SolicitudAccesoDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        return service.deleteAll();
    }
}
