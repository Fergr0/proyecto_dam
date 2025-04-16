package com.example.proyectoDam.service.impl;

import com.example.proyectoDam.model.InstalacionDto;
import com.example.proyectoDam.model.InstalacionVO;
import com.example.proyectoDam.repository.InstalacionRepository;
import com.example.proyectoDam.service.InstalacionService;
import com.example.proyectoDam.util.InstalacionConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz {@link InstalacionService}.
 * Gestiona la lógica de negocio relacionada con las instalaciones.
 */
@Service
public class InstalacionServiceImpl implements InstalacionService {

    @Autowired
    private InstalacionRepository instalacionRepository;

    @Override
    public List<InstalacionDto> getAllInstalaciones() {
        return instalacionRepository.findAll()
                .stream()
                .map(InstalacionConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InstalacionDto> getInstalacionById(String id) {
        return instalacionRepository.findById(id)
                .map(InstalacionConverter::toDto);
    }

    @Override
    public List<InstalacionDto> findByNombre(String nombre) {
        return instalacionRepository.findByNombre(nombre)
                .stream()
                .map(InstalacionConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstalacionDto> findByIdAdministrador(String idAdministrador) {
        return instalacionRepository.findByIdAdministrador(idAdministrador)
                .stream()
                .map(InstalacionConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstalacionDto save(InstalacionDto instalacionDto) {
        InstalacionVO vo = InstalacionConverter.toVO(instalacionDto);
        InstalacionVO saved = instalacionRepository.save(vo);
        return InstalacionConverter.toDto(saved);
    }

    @Override
    public InstalacionDto updateInstalacion(InstalacionDto instalacionDto) {
        if (!instalacionRepository.existsById(instalacionDto.getId())) {
            throw new RuntimeException("Instalación no encontrada con ID: " + instalacionDto.getId());
        }
        InstalacionVO vo = InstalacionConverter.toVO(instalacionDto);
        InstalacionVO updated = instalacionRepository.save(vo);
        return InstalacionConverter.toDto(updated);
    }

    @Override
    public ResponseEntity<Void> deleteInstalacion(String id) {
        if (!instalacionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        instalacionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllInstalaciones() {
        instalacionRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
