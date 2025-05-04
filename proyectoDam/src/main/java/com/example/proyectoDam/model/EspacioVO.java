package com.example.proyectoDam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
@Document(collection = "espacios") // Mapea esta clase a la colección "espacios" en MongoDB
public class EspacioVO {

	@Id
	private String id;

	private String nombre;

	private String tipo; // Ej: "Pista de padel", "Sala de reuniones"

	private String idInstalacion; // A qué instalación pertenece

	private String descripcion;

}
