package com.example.proyectoDam.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Clase que representa el dto de Instalacion*/

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class InstalacionDto {
	
    // Identificador único del documento
    private String id;

    /*Nombre de la instalacion*/
    private String nombre;
    
    private String descripcion;

    // Usuario que la gestiona
    private String idAdministrador; 
    
    // Lista de usuarios (clientes) aceptados
    private List<String> idsUsuariosPermitidos; 
}
