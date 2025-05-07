package com.example.proyectoDam.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class SolicitudAccesoDto {

    private String id;
    private String idUsuario;
    private String idInstalacion;
    private String estado;
    private LocalDateTime fechaSolicitud;


}
