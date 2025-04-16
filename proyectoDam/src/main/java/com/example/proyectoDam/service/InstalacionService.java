package com.example.proyectoDam.service;

import com.example.proyectoDam.model.InstalacionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para la gestión de instalaciones.
 * Define las operaciones de negocio relacionadas con clubes, centros deportivos, etc.
 */
public interface InstalacionService {

    /**
     * Obtiene todas las instalaciones registradas.
     *
     * @return lista de instalaciones.
     */
    List<InstalacionDto> getAllInstalaciones();

    /**
     * Busca una instalación por su identificador único.
     *
     * @param id ID de la instalación.
     * @return un Optional con la instalación si existe, vacío si no.
     */
    Optional<InstalacionDto> getInstalacionById(String id);

    /**
     * Busca instalaciones por nombre.
     *
     * @param nombre nombre de la instalación.
     * @return lista de instalaciones que coincidan.
     */
    List<InstalacionDto> findByNombre(String nombre);

    /**
     * Busca instalaciones gestionadas por un administrador específico.
     *
     * @param idAdministrador ID del administrador.
     * @return lista de instalaciones asociadas a ese administrador.
     */
    List<InstalacionDto> findByIdAdministrador(String idAdministrador);

    /**
     * Guarda una nueva instalación.
     *
     * @param instalacionDto datos de la instalación a guardar.
     * @return la instalación guardada con ID generado.
     */
    InstalacionDto save(InstalacionDto instalacionDto);

    /**
     * Actualiza una instalación existente.
     *
     * @param instalacionDto datos actualizados de la instalación.
     * @return la instalación actualizada.
     */
    InstalacionDto updateInstalacion(InstalacionDto instalacionDto);

    /**
     * Elimina una instalación por su ID.
     *
     * @param id ID de la instalación a eliminar.
     * @return respuesta vacía (204) si se elimina correctamente.
     */
    ResponseEntity<Void> deleteInstalacion(String id);

    /**
     * Elimina todas las instalaciones.
     *
     * @return respuesta vacía (204) si se eliminan correctamente.
     */
    ResponseEntity<Void> deleteAllInstalaciones();
}
