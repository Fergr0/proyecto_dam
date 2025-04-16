package com.example.proyectoDam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.proyectoDam.model.InstalacionVO;

/**
 * Repositorio para acceder a la colección de instalaciones en MongoDB.
 * Hereda de {@link MongoRepository} para proporcionar operaciones CRUD automáticas.
 */
@Repository
public interface InstalacionRepository extends MongoRepository<InstalacionVO, String> {

    /**
     * Busca instalaciones por nombre (puede haber varias con el mismo nombre).
     * 
     * @param nombre el nombre de la instalación.
     * @return lista de instalaciones que coincidan.
     */
    List<InstalacionVO> findByNombre(String nombre);

    /**
     * Busca instalaciones gestionadas por un administrador específico.
     * 
     * @param idAdministrador ID del administrador.
     * @return lista de instalaciones asociadas a ese administrador.
     */
    List<InstalacionVO> findByIdAdministrador(String idAdministrador);
}
