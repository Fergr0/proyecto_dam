package com.example.proyectoDam.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Entidad Reserva
 * 
 * */
@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
@Document(collection = "reservas") // Mapea esta clase a la colección "instalacion" en MongoDB
public class ReservaVO {

    @Id
    private String id;

    private String idUsuario;

    private String idEspacio;

    private LocalDate fecha;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private String estado; // Ej: "PENDIENTE", "ACEPTADA", "RECHAZADA", etc.

	
}
