package com.example.proyectoDam.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.proyectoDam.model.UsuarioDto;
import com.example.proyectoDam.model.UsuarioVO;

/**
 * Clase de utilidad para convertir entre objetos {@link UsuarioDto} (usados en la capa de presentación)
 * y {@link UsuarioVO} (entidades persistentes usadas en la base de datos).
 * 
 * Facilita la separación de capas en la arquitectura de la aplicación.
 */
public class UsuarioConverter {

    /**
     * Convierte un objeto {@link UsuarioDto} a un {@link UsuarioVO}, que será utilizado para persistencia.
     * 
     * @param dto el objeto UsuarioDto a convertir.
     * @return un objeto UsuarioVO equivalente, o {@code null} si el DTO es {@code null}.
     */
    public static UsuarioVO toVO(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        return new UsuarioVO(
                null, // El ID será generado automáticamente por MongoDB al guardar
                dto.getNombre(),
                dto.getApellidos(),
                dto.getMail(),
                dto.getTelefono(),
                dto.getRol(),
                dto.getCodigosInstalacionesPermitidas(),
                dto.getPassword()
        );
    }

    /**
     * Convierte un objeto {@link UsuarioVO} a un {@link UsuarioDto}, utilizado para devolver datos al cliente.
     * 
     * @param vo el objeto UsuarioVO a convertir.
     * @return un objeto UsuarioDto equivalente, o {@code null} si el VO es {@code null}.
     */
    public static UsuarioDto toDto(UsuarioVO vo) {
        if (vo == null) {
            return null;
        }
        return new UsuarioDto(
                vo.getId(),
                vo.getNombre(),
                vo.getApellidos(),
                vo.getMail(),
                vo.getTelefono(),
                vo.getRol(),
                vo.getCodigosInstalacionesPermitidas(),
                vo.getPassword()
        );
    }

    /**
     * Convierte una lista de {@link UsuarioDto} a una lista de {@link UsuarioVO}.
     * 
     * @param dtoList la lista de DTOs a convertir.
     * @return una lista de VOs equivalente, o una lista vacía si la entrada es {@code null} o vacía.
     */
    public static List<UsuarioVO> toVOList(List<UsuarioDto> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of(); // Devuelve lista vacía si null o vacía
        }
        return dtoList.stream()
                .map(UsuarioConverter::toVO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de {@link UsuarioVO} a una lista de {@link UsuarioDto}.
     * 
     * @param voList la lista de VOs a convertir.
     * @return una lista de DTOs equivalente, o una lista vacía si la entrada es {@code null} o vacía.
     */
    public static List<UsuarioDto> toDtoList(List<UsuarioVO> voList) {
        if (voList == null || voList.isEmpty()) {
            return List.of(); // Devuelve lista vacía si null o vacía
        }
        return voList.stream()
                .map(UsuarioConverter::toDto)
                .collect(Collectors.toList());
    }
}
