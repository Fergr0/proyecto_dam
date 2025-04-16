package com.example.proyectoDam.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Entidad instalacion
 * Representa un club, instituto, edificio...
 * */
@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
@Document(collection = "instalacion") // Mapea esta clase a la colección "usuarios" en MongoDB
public class InstalacionVO {
	
    @Id // Identificador único del documento
    private String id;

    /*Nombre de la instalacion*/
    private String nombre;
    
    private String descripcion;

    // Usuario que la gestiona
    private String idAdministrador; 
    
    // Lista de usuarios (clientes) aceptados
    private List<String> idsUsuariosPermitidos; 

}
