package com.example.proyectoDam.controller.impl;

import com.example.proyectoDam.controller.ReservaAPI;
import com.example.proyectoDam.model.ReservaDto;
import com.example.proyectoDam.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implementación del controlador REST para la gestión de reservas.
 */
@RestController
@RequestMapping("/api/reservas")
public class ReservaControllerImpl implements ReservaAPI {

    @Autowired
    private ReservaService reservaService;

    @Override
    @GetMapping
    public ResponseEntity<List<ReservaDto>> getAllReservas() {
        return ResponseEntity.ok(reservaService.getAllReservas());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> getReservaById(@PathVariable String id) {
        return reservaService.getReservaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaDto>> findByIdUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(reservaService.findByIdUsuario(idUsuario));
    }

    @Override
    @GetMapping("/espacio/{idEspacio}")
    public ResponseEntity<List<ReservaDto>> findByIdEspacio(@PathVariable String idEspacio) {
        return ResponseEntity.ok(reservaService.findByIdEspacio(idEspacio));
    }

    @Override
    @PostMapping
    public ResponseEntity<ReservaDto> saveReserva(@RequestBody ReservaDto reservaDto) {
        return ResponseEntity.ok(reservaService.save(reservaDto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> updateReserva(@PathVariable String id, @RequestBody ReservaDto reservaDto) {
        reservaDto.setId(id);
        return ResponseEntity.ok(reservaService.updateReserva(reservaDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable String id) {
        return reservaService.deleteReserva(id);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllReservas() {
        return reservaService.deleteAllReservas();
    }
}
