package com.example.proyectoDam.service.impl;

import com.example.proyectoDam.model.EspacioDto;
import com.example.proyectoDam.model.EspacioVO;
import com.example.proyectoDam.repository.EspacioRepository;
import com.example.proyectoDam.service.EspacioService;
import com.example.proyectoDam.util.EspacioConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz {@link EspacioService}.
 * Gestiona la lógica de negocio relacionada con los espacios de las instalaciones.
 */
@Service
public class EspacioServiceImpl implements EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    @Override
    public List<EspacioDto> getAllEspacios() {
        return espacioRepository.findAll()
                .stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EspacioDto> getEspacioById(String id) {
        return espacioRepository.findById(id)
                .map(EspacioConverter::toDto);
    }

    @Override
    public List<EspacioDto> findByNombre(String nombre) {
        return espacioRepository.findByNombre(nombre)
                .stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EspacioDto> findByNombreAndIdInstalacion(String nombre, String idInstalacion) {
        return espacioRepository.findByNombreAndIdInstalacion(nombre, idInstalacion)
                .stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EspacioDto> findByIdInstalacion(String idInstalacion) {
        return espacioRepository.findByIdInstalacion(idInstalacion)
                .stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EspacioDto> findByTipo(String tipo) {
        return espacioRepository.findByTipo(tipo)
                .stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EspacioDto save(EspacioDto espacioDto) {
        EspacioVO vo = EspacioConverter.toVO(espacioDto);
        EspacioVO saved = espacioRepository.save(vo);
        return EspacioConverter.toDto(saved);
    }

    @Override
    public EspacioDto updateEspacio(EspacioDto espacioDto) {
        if (!espacioRepository.existsById(espacioDto.getId())) {
            throw new RuntimeException("Espacio no encontrado con ID: " + espacioDto.getId());
        }
        EspacioVO vo = EspacioConverter.toVO(espacioDto);
        EspacioVO updated = espacioRepository.save(vo);
        return EspacioConverter.toDto(updated);
    }

    @Override
    public ResponseEntity<Void> deleteEspacio(String id) {
        if (!espacioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        espacioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllEspacios() {
        espacioRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
