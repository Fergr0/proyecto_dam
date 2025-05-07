package com.example.proyectoDam.controller;

import com.example.proyectoDam.model.SolicitudAccesoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SolicitudAccesoAPI {

    ResponseEntity<List<SolicitudAccesoDto>> getAll();

    ResponseEntity<SolicitudAccesoDto> getById(String id);

    ResponseEntity<List<SolicitudAccesoDto>> getByIdUsuario(String idUsuario);

    ResponseEntity<List<SolicitudAccesoDto>> getByIdInstalacion(String idInstalacion);

    ResponseEntity<SolicitudAccesoDto> save(SolicitudAccesoDto dto);

    ResponseEntity<SolicitudAccesoDto> update(String id, SolicitudAccesoDto dto);

    ResponseEntity<Void> deleteById(String id);

    ResponseEntity<Void> deleteAll();
}
