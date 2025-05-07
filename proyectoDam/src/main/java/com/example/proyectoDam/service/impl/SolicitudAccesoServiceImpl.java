package com.example.proyectoDam.service.impl;

import com.example.proyectoDam.model.SolicitudAccesoDto;
import com.example.proyectoDam.model.SolicitudAccesoVO;
import com.example.proyectoDam.repository.SolicitudAccesoRepository;
import com.example.proyectoDam.service.SolicitudAccesoService;
import com.example.proyectoDam.util.SolicitudAccesoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudAccesoServiceImpl implements SolicitudAccesoService {

    @Autowired
    private SolicitudAccesoRepository repository;

    @Override
    public List<SolicitudAccesoDto> getAll() {
        return SolicitudAccesoConverter.toDtoList(repository.findAll());
    }

    @Override
    public Optional<SolicitudAccesoDto> getById(String id) {
        return repository.findById(id).map(SolicitudAccesoConverter::toDto);
    }

    @Override
    public List<SolicitudAccesoDto> findByIdUsuario(String idUsuario) {
        return SolicitudAccesoConverter.toDtoList(repository.findByIdUsuario(idUsuario));
    }

    @Override
    public List<SolicitudAccesoDto> findByIdInstalacion(String idInstalacion) {
        return SolicitudAccesoConverter.toDtoList(repository.findByIdInstalacion(idInstalacion));
    }

    @Override
    public SolicitudAccesoDto save(SolicitudAccesoDto dto) {
        // Evitar duplicados "PENDIENTE"
        Optional<SolicitudAccesoVO> existente = repository
            .findByIdUsuarioAndIdInstalacionAndEstado(dto.getIdUsuario(), dto.getIdInstalacion(), "PENDIENTE");

        if (existente.isPresent()) {
            throw new RuntimeException("Ya existe una solicitud PENDIENTE para ese usuario e instalación.");
        }

        SolicitudAccesoVO saved = repository.save(SolicitudAccesoConverter.toVO(dto));
        return SolicitudAccesoConverter.toDto(saved);
    }

    @Override
    public SolicitudAccesoDto update(SolicitudAccesoDto dto) {
        if (!repository.existsById(dto.getId())) {
            throw new RuntimeException("Solicitud no encontrada con ID: " + dto.getId());
        }
        SolicitudAccesoVO updated = repository.save(SolicitudAccesoConverter.toVO(dto));
        return SolicitudAccesoConverter.toDto(updated);
    }

    @Override
    public ResponseEntity<Void> deleteById(String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
