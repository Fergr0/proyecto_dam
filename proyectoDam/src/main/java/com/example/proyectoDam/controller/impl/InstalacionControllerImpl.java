package com.example.proyectoDam.controller.impl;

import com.example.proyectoDam.controller.InstalacionAPI;
import com.example.proyectoDam.model.InstalacionDto;
import com.example.proyectoDam.service.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implementación del controlador REST para la gestión de instalaciones.
 * Expone los endpoints definidos en la interfaz {@link InstalacionAPI}.
 */
@RestController
@RequestMapping("/api/instalaciones") // para seguridad y consistencia
public class InstalacionControllerImpl implements InstalacionAPI {

    @Autowired
    private InstalacionService instalacionService;

    @Override
    @GetMapping
    public ResponseEntity<List<InstalacionDto>> getAllInstalaciones() {
        List<InstalacionDto> instalaciones = instalacionService.getAllInstalaciones();
        return ResponseEntity.ok(instalaciones);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<InstalacionDto> getInstalacionById(@PathVariable String id) {
        return instalacionService.getInstalacionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<InstalacionDto>> findByNombre(@PathVariable String nombre) {
        List<InstalacionDto> instalaciones = instalacionService.findByNombre(nombre);
        return ResponseEntity.ok(instalaciones);
    }

    @Override
    @GetMapping("/buscar/admin/{idAdministrador}")
    public ResponseEntity<List<InstalacionDto>> findByIdAdministrador(@PathVariable String idAdministrador) {
        List<InstalacionDto> instalaciones = instalacionService.findByIdAdministrador(idAdministrador);
        return ResponseEntity.ok(instalaciones);
    }

    @Override
    @PostMapping
    public ResponseEntity<InstalacionDto> saveInstalacion(@RequestBody InstalacionDto instalacionDto) {
        InstalacionDto guardada = instalacionService.save(instalacionDto);
        return ResponseEntity.ok(guardada);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<InstalacionDto> updateInstalacion(@PathVariable String id, @RequestBody InstalacionDto instalacionDto) {
        instalacionDto.setId(id);
        InstalacionDto actualizada = instalacionService.updateInstalacion(instalacionDto);
        return ResponseEntity.ok(actualizada);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacion(@PathVariable String id) {
        return instalacionService.deleteInstalacion(id);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllInstalaciones() {
        return instalacionService.deleteAllInstalaciones();
    }
}
