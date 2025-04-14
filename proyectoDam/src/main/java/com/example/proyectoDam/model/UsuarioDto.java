package com.example.proyectoDam.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class UsuarioDto {
	
	private String id;

    private String nombre;

    private String apellidos;

    private String mail;

    private String telefono;

    private String rol;
    
    private List<String> codigosInstalacionesPermitidas; // Instalaciones a las que tiene acceso

    private String password; // Encriptada
}