package com.example.proyectoDam.service;

import com.example.proyectoDam.model.SolicitudAccesoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SolicitudAccesoService {

    List<SolicitudAccesoDto> getAll();

    Optional<SolicitudAccesoDto> getById(String id);

    List<SolicitudAccesoDto> findByIdUsuario(String idUsuario);

    List<SolicitudAccesoDto> findByIdInstalacion(String idInstalacion);

    SolicitudAccesoDto save(SolicitudAccesoDto dto);

    SolicitudAccesoDto update(SolicitudAccesoDto dto);

    ResponseEntity<Void> deleteById(String id);

    ResponseEntity<Void> deleteAll();
}
