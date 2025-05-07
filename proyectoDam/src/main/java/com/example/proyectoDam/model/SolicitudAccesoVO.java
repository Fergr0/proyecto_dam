package com.example.proyectoDam.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Entidad solicitud de acceso
 * Representa la solicitud de acceso de un usuario a una instalacion
 * */
@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
@Document(collection = "solicitudesAcceso") // Mapea esta clase a la colección "instalacion" en MongoDB
public class SolicitudAccesoVO {
	
	   @Id
	    private String id;

	    private String idUsuario;

	    private String idInstalacion;

	    private String estado; // "PENDIENTE", "APROBADA", "RECHAZADA"

	    private LocalDateTime fechaSolicitud;
	
}
