package com.example.proyectoDam.controller;

import com.example.proyectoDam.model.InstalacionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InstalacionAPI {

    ResponseEntity<List<InstalacionDto>> getAllInstalaciones();

    ResponseEntity<InstalacionDto> getInstalacionById(String id);

    ResponseEntity<List<InstalacionDto>> findByNombre(String nombre);

    ResponseEntity<List<InstalacionDto>> findByIdAdministrador(String idAdministrador);

    ResponseEntity<InstalacionDto> saveInstalacion(InstalacionDto instalacionDto);

    ResponseEntity<InstalacionDto> updateInstalacion(String id, InstalacionDto instalacionDto);

    ResponseEntity<Void> deleteInstalacion(String id);

    ResponseEntity<Void> deleteAllInstalaciones();
}
