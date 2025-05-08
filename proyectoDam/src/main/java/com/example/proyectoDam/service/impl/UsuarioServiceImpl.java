package com.example.proyectoDam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.proyectoDam.model.UsuarioDto;
import com.example.proyectoDam.model.UsuarioVO;
import com.example.proyectoDam.repository.UsuarioRepository;
import com.example.proyectoDam.service.UsuarioService;
import com.example.proyectoDam.util.JwtUtil;
import com.example.proyectoDam.util.UsuarioConverter;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;


    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JwtUtil jwtUtil;

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
	public Optional<UsuarioDto> findByMail(String mail) {
		return usuarioRepository.findByMail(mail).map(UsuarioConverter::toDto);
	}
	
    @Override
    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto) {
        // Encriptar contraseña antes de guardar
        usuarioDto.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        UsuarioVO usuarioVO = UsuarioConverter.toVO(usuarioDto);
        UsuarioVO saved = usuarioRepository.save(usuarioVO);
        return UsuarioConverter.toDto(saved);
    }

    @Override
    public String login(String mail, String password) {
        UsuarioVO usuario = usuarioRepository.findByMail(mail)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        System.out.println("Contraseña enviada: " + password);
        System.out.println("Contraseña en BD: " + usuario.getPassword());
        System.out.println("Match? " + passwordEncoder.matches(password, usuario.getPassword()));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(usuario.getId(), usuario.getRol());
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
