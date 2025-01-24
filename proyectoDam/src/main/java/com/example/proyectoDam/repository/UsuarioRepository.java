package com.example.proyectoDam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.proyectoDam.model.UsuarioVO;

public interface UsuarioRepository extends MongoRepository<UsuarioVO, String>{

	
    // Obtener todos los usuarios
    List<UsuarioVO> findAll();

    // Buscar un usuario por ID
    Optional<UsuarioVO> findById(String id);

    // Buscar usuarios por nombre
    List<UsuarioVO> findByNombre(String nombre);

    // Buscar usuarios por rol
    List<UsuarioVO> findByRol(String rol);

    // Eliminar un usuario por ID
    void deleteById(String id);
	
}
