package com.example.proyectoDam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
@Document(collection = "usuarios") // Mapea esta clase a la colección "usuarios" en MongoDB
public class UsuarioVO {

    @Id // Identificador único del documento
    private String id;

    private String nombre;

    private String apellidos;

    private String mail;

    private String telefono;

    private String rol;
}
