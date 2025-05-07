package com.example.proyectoDam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.proyectoDam.model.ReservaVO;

/**
 * Repositorio de reservas, proporciona acceso a operaciones CRUD y consultas personalizadas.
 */
public interface ReservaRepository extends MongoRepository<ReservaVO, String> {

    /**
     * Buscar reservas por ID de usuario.
     *
     * @param idUsuario ID del usuario.
     * @return lista de reservas asociadas al usuario.
     */
    List<ReservaVO> findByIdUsuario(String idUsuario);

    /**
     * Buscar reservas por ID de espacio.
     *
     * @param idEspacio ID del espacio.
     * @return lista de reservas asociadas al espacio.
     */
    List<ReservaVO> findByIdEspacio(String idEspacio);
}
