package com.example.proyectoDam.service.impl;

import com.example.proyectoDam.model.ReservaDto;
import com.example.proyectoDam.model.ReservaVO;
import com.example.proyectoDam.repository.ReservaRepository;
import com.example.proyectoDam.service.ReservaService;
import com.example.proyectoDam.util.ReservaConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz {@link ReservaService}.
 * Gestiona la lógica de negocio relacionada con las reservas.
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<ReservaDto> getAllReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(ReservaConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservaDto> getReservaById(String id) {
        return reservaRepository.findById(id)
                .map(ReservaConverter::toDto);
    }

    @Override
    public List<ReservaDto> findByIdUsuario(String idUsuario) {
        return reservaRepository.findByIdUsuario(idUsuario)
                .stream()
                .map(ReservaConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDto> findByIdEspacio(String idEspacio) {
        return reservaRepository.findByIdEspacio(idEspacio)
                .stream()
                .map(ReservaConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDto save(ReservaDto reservaDto) {
        ReservaVO vo = ReservaConverter.toVO(reservaDto);
        ReservaVO saved = reservaRepository.save(vo);
        return ReservaConverter.toDto(saved);
    }

    @Override
    public ReservaDto updateReserva(ReservaDto reservaDto) {
        if (!reservaRepository.existsById(reservaDto.getId())) {
            throw new RuntimeException("Reserva no encontrada con ID: " + reservaDto.getId());
        }
        ReservaVO vo = ReservaConverter.toVO(reservaDto);
        ReservaVO updated = reservaRepository.save(vo);
        return ReservaConverter.toDto(updated);
    }

    @Override
    public ResponseEntity<Void> deleteReserva(String id) {
        if (!reservaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllReservas() {
        reservaRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
