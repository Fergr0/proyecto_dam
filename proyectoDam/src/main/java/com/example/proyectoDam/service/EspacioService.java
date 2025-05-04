package com.example.proyectoDam.service;

import com.example.proyectoDam.model.EspacioDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para la gestión de espacios (pistas, salas, auditorios, etc.)
 * Define las operaciones de negocio relacionadas con los espacios dentro de las instalaciones.
 */
public interface EspacioService {

    /**
     * Obtiene todos los espacios registrados.
     *
     * @return lista de espacios.
     */
    List<EspacioDto> getAllEspacios();

    /**
     * Busca un espacio por su identificador único.
     *
     * @param id ID del espacio.
     * @return un Optional con el espacio si existe, vacío si no.
     */
    Optional<EspacioDto> getEspacioById(String id);

    /**
     * Busca espacios por nombre exacto.
     *
     * @param nombre nombre del espacio.
     * @return lista de espacios que coincidan.
     */
    List<EspacioDto> findByNombre(String nombre);

    /**
     * Busca espacios por nombre e ID de instalación.
     *
     * @param nombre nombre del espacio.
     * @param idInstalacion ID de la instalación.
     * @return lista de espacios coincidentes.
     */
    List<EspacioDto> findByNombreAndIdInstalacion(String nombre, String idInstalacion);

    /**
     * Busca espacios por ID de instalación.
     *
     * @param idInstalacion ID de la instalación.
     * @return lista de espacios en dicha instalación.
     */
    List<EspacioDto> findByIdInstalacion(String idInstalacion);

    /**
     * Busca espacios por tipo (ej: "Pista de padel", "Sala de reuniones").
     *
     * @param tipo tipo del espacio.
     * @return lista de espacios del tipo indicado.
     */
    List<EspacioDto> findByTipo(String tipo);

    /**
     * Guarda un nuevo espacio.
     *
     * @param espacioDto datos del espacio a guardar.
     * @return el espacio guardado con ID generado.
     */
    EspacioDto save(EspacioDto espacioDto);

    /**
     * Actualiza un espacio existente.
     *
     * @param espacioDto datos actualizados del espacio.
     * @return el espacio actualizado.
     */
    EspacioDto updateEspacio(EspacioDto espacioDto);

    /**
     * Elimina un espacio por su ID.
     *
     * @param id ID del espacio a eliminar.
     * @return respuesta vacía (204) si se elimina correctamente.
     */
    ResponseEntity<Void> deleteEspacio(String id);

    /**
     * Elimina todos los espacios.
     *
     * @return respuesta vacía (204) si se eliminan correctamente.
     */
    ResponseEntity<Void> deleteAllEspacios();
}
