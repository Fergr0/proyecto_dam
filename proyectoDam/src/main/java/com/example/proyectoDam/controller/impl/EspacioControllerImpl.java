package com.example.proyectoDam.controller.impl;

import com.example.proyectoDam.controller.EspacioAPI;
import com.example.proyectoDam.model.EspacioDto;
import com.example.proyectoDam.service.EspacioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implementación del controlador REST para la gestión de espacios.
 * Expone los endpoints definidos en la interfaz {@link EspacioAPI}.
 */
@RestController
@RequestMapping("/api/espacios")
public class EspacioControllerImpl implements EspacioAPI {

    @Autowired
    private EspacioService espacioService;

    @Override
    @GetMapping
    public ResponseEntity<List<EspacioDto>> getAllEspacios() {
        return ResponseEntity.ok(espacioService.getAllEspacios());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EspacioDto> getEspacioById(@PathVariable String id) {
        return espacioService.getEspacioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<List<EspacioDto>> findByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(espacioService.findByNombre(nombre));
    }

    @Override
    @GetMapping("/buscar/{nombre}/{idInstalacion}")
    public ResponseEntity<List<EspacioDto>> findByNombreAndIdInstalacion(
            @PathVariable String nombre,
            @PathVariable String idInstalacion) {
        return ResponseEntity.ok(espacioService.findByNombreAndIdInstalacion(nombre, idInstalacion));
    }


    @Override
    @GetMapping("/buscar/instalacion/{idInstalacion}")
    public ResponseEntity<List<EspacioDto>> findByIdInstalacion(@PathVariable String idInstalacion) {
        return ResponseEntity.ok(espacioService.findByIdInstalacion(idInstalacion));
    }

    @Override
    @GetMapping("/buscar/tipo/{tipo}")
    public ResponseEntity<List<EspacioDto>> findByTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(espacioService.findByTipo(tipo));
    }

    @Override
    @PostMapping
    public ResponseEntity<EspacioDto> saveEspacio(@RequestBody EspacioDto espacioDto) {
        return ResponseEntity.ok(espacioService.save(espacioDto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EspacioDto> updateEspacio(@PathVariable String id, @RequestBody EspacioDto espacioDto) {
        espacioDto.setId(id);
        return ResponseEntity.ok(espacioService.updateEspacio(espacioDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspacio(@PathVariable String id) {
        return espacioService.deleteEspacio(id);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEspacios() {
        return espacioService.deleteAllEspacios();
    }
}
