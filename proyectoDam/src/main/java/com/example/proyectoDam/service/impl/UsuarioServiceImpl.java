package com.example.proyectoDam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proyectoDam.model.UsuarioDto;
import com.example.proyectoDam.model.UsuarioVO;
import com.example.proyectoDam.repository.UsuarioRepository;
import com.example.proyectoDam.service.UsuarioService;
import com.example.proyectoDam.util.UsuarioConverter;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioConverter::toDto) // Convertir VO a DTO
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDto> getUsuarioById(String id) {
        return usuarioRepository.findById(id)
                .map(UsuarioConverter::toDto); // Convertir VO a DTO
    }

    @Override
    public List<UsuarioDto> findByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre)
                .stream()
                .map(UsuarioConverter::toDto) // Convertir VO a DTO
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> findByRol(String rol) {
        return usuarioRepository.findByRol(rol)
                .stream()
                .map(UsuarioConverter::toDto) // Convertir VO a DTO
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        UsuarioVO usuarioVO = UsuarioConverter.toVO(usuarioDto); // Convertir DTO a VO
        UsuarioVO savedUsuario = usuarioRepository.save(usuarioVO);
        return UsuarioConverter.toDto(savedUsuario); // Convertir VO a DTO
    }

    @Override
    public UsuarioDto updateUsuario(UsuarioDto usuarioDto) {
        if (!usuarioRepository.existsById(usuarioDto.getId())) {
            throw new RuntimeException("Usuario no encontrado");
        }
        UsuarioVO usuarioVO = UsuarioConverter.toVO(usuarioDto); // Convertir DTO a VO
        UsuarioVO updatedUsuario = usuarioRepository.save(usuarioVO); // Actualizar
        return UsuarioConverter.toDto(updatedUsuario); // Convertir VO a DTO
    }

    @Override
    public ResponseEntity deleteUsuario(String id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity deleteAllUsuarios() {
        usuarioRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
