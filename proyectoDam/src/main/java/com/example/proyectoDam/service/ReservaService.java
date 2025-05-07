package com.example.proyectoDam.service;

import com.example.proyectoDam.model.ReservaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para la gestión de reservas de espacios.
 * Define las operaciones de negocio relacionadas con las reservas realizadas por los usuarios.
 */
public interface ReservaService {

    /**
     * Obtiene todas las reservas registradas.
     *
     * @return lista de reservas.
     */
    List<ReservaDto> getAllReservas();

    /**
     * Busca una reserva por su identificador único.
     *
     * @param id ID de la reserva.
     * @return un Optional con la reserva si existe, vacío si no.
     */
    Optional<ReservaDto> getReservaById(String id);

    /**
     * Busca reservas por ID de usuario.
     *
     * @param idUsuario ID del usuario.
     * @return lista de reservas realizadas por ese usuario.
     */
    List<ReservaDto> findByIdUsuario(String idUsuario);

    /**
     * Busca reservas por ID de espacio.
     *
     * @param idEspacio ID del espacio.
     * @return lista de reservas asociadas a ese espacio.
     */
    List<ReservaDto> findByIdEspacio(String idEspacio);

    /**
     * Guarda una nueva reserva.
     *
     * @param reservaDto datos de la reserva a guardar.
     * @return la reserva guardada con ID generado.
     */
    ReservaDto save(ReservaDto reservaDto);

    /**
     * Actualiza una reserva existente.
     *
     * @param reservaDto datos actualizados de la reserva.
     * @return la reserva actualizada.
     */
    ReservaDto updateReserva(ReservaDto reservaDto);

    /**
     * Elimina una reserva por su ID.
     *
     * @param id ID de la reserva a eliminar.
     * @return respuesta vacía (204) si se elimina correctamente.
     */
    ResponseEntity<Void> deleteReserva(String id);

    /**
     * Elimina todas las reservas.
     *
     * @return respuesta vacía (204) si se eliminan correctamente.
     */
    ResponseEntity<Void> deleteAllReservas();
}
