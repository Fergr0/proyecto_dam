package com.example.proyectoDam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.proyectoDam.model.EspacioVO;

public interface EspacioRepository extends MongoRepository<EspacioVO, String> {

    // Obtener todos los espacios
    List<EspacioVO> findAll();

    // Buscar un espacio por ID
    Optional<EspacioVO> findById(String id);

    // Buscar espacios por nombre exacto
    List<EspacioVO> findByNombre(String nombre);

    // Buscar espacios por nombre e instalación
    List<EspacioVO> findByNombreAndIdInstalacion(String nombre, String idInstalacion);

    // Buscar espacios por instalación
    List<EspacioVO> findByIdInstalacion(String idInstalacion);

    // Buscar espacios por tipo (ej. "Pista de padel")
    List<EspacioVO> findByTipo(String tipo);

    // Eliminar un espacio por ID
    void deleteById(String id);
}
