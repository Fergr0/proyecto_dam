package com.example.proyectoDam.controller;

import com.example.proyectoDam.model.ReservaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservaAPI {

    ResponseEntity<List<ReservaDto>> getAllReservas();

    ResponseEntity<ReservaDto> getReservaById(String id);

    ResponseEntity<List<ReservaDto>> findByIdUsuario(String idUsuario);

    ResponseEntity<List<ReservaDto>> findByIdEspacio(String idEspacio);

    ResponseEntity<ReservaDto> saveReserva(ReservaDto reservaDto);

    ResponseEntity<ReservaDto> updateReserva(String id, ReservaDto reservaDto);

    ResponseEntity<Void> deleteReserva(String id);

    ResponseEntity<Void> deleteAllReservas();
}
