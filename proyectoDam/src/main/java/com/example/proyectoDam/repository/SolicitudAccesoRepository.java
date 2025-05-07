package com.example.proyectoDam.repository;

import com.example.proyectoDam.model.SolicitudAccesoVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SolicitudAccesoRepository extends MongoRepository<SolicitudAccesoVO, String> {

    List<SolicitudAccesoVO> findByIdUsuario(String idUsuario);

    List<SolicitudAccesoVO> findByIdInstalacion(String idInstalacion);

    Optional<SolicitudAccesoVO> findByIdUsuarioAndIdInstalacionAndEstado(String idUsuario, String idInstalacion, String estado);
}
