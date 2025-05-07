package com.example.proyectoDam.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class ReservaDto {
	
    private String id;

    private String idUsuario;

    private String idEspacio;

    private LocalDate fecha;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private String estado; // Ej: "PENDIENTE", "ACEPTADA", "RECHAZADA", etc.

}
