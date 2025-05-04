package com.example.proyectoDam.controller;

import com.example.proyectoDam.model.EspacioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EspacioAPI {

    ResponseEntity<List<EspacioDto>> getAllEspacios();

    ResponseEntity<EspacioDto> getEspacioById(String id);

    ResponseEntity<List<EspacioDto>> findByNombre(String nombre);

    ResponseEntity<List<EspacioDto>> findByNombreAndIdInstalacion(String nombre, String idInstalacion);
    

    ResponseEntity<List<EspacioDto>> findByIdInstalacion(String idInstalacion);

    ResponseEntity<List<EspacioDto>> findByTipo(String tipo);

    ResponseEntity<EspacioDto> saveEspacio(EspacioDto espacioDto);

    ResponseEntity<EspacioDto> updateEspacio(String id, EspacioDto espacioDto);

    ResponseEntity<Void> deleteEspacio(String id);

    ResponseEntity<Void> deleteAllEspacios();
}
