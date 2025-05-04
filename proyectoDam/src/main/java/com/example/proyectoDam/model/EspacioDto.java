package com.example.proyectoDam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos

public class EspacioDto {

	private String id;

	private String nombre;

	private String tipo;
	
	private String idInstalacion; 

	private String descripcion;
}
