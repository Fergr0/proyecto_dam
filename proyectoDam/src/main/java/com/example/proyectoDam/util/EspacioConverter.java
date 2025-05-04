package com.example.proyectoDam.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.proyectoDam.model.EspacioDto;
import com.example.proyectoDam.model.EspacioVO;

/**
 * Clase de utilidad para convertir entre objetos {@link EspacioDto} (usados en la capa de presentación)
 * y {@link EspacioVO} (entidades persistentes usadas en la base de datos).
 * 
 * Facilita la separación de capas en la arquitectura de la aplicación.
 */
public class EspacioConverter {

    /**
     * Convierte un objeto {@link EspacioDto} a un {@link EspacioVO}, que será utilizado para persistencia.
     * 
     * @param dto el objeto EspacioDto a convertir.
     * @return un objeto EspacioVO equivalente, o {@code null} si el DTO es {@code null}.
     */
    public static EspacioVO toVO(EspacioDto dto) {
        if (dto == null) {
            return null;
        }
        return new EspacioVO(
                dto.getId(), // También puedes usar null si prefieres que lo genere MongoDB
                dto.getNombre(),
                dto.getTipo(),
                dto.getIdInstalacion(),
                dto.getDescripcion()
        );
    }

    /**
     * Convierte un objeto {@link EspacioVO} a un {@link EspacioDto}, utilizado para devolver datos al cliente.
     * 
     * @param vo el objeto EspacioVO a convertir.
     * @return un objeto EspacioDto equivalente, o {@code null} si el VO es {@code null}.
     */
    public static EspacioDto toDto(EspacioVO vo) {
        if (vo == null) {
            return null;
        }
        return new EspacioDto(
                vo.getId(),
                vo.getNombre(),
                vo.getTipo(),
                vo.getIdInstalacion(),
                vo.getDescripcion()
        );
    }

    /**
     * Convierte una lista de {@link EspacioDto} a una lista de {@link EspacioVO}.
     * 
     * @param dtoList la lista de DTOs a convertir.
     * @return una lista de VOs equivalente, o una lista vacía si la entrada es {@code null} o vacía.
     */
    public static List<EspacioVO> toVOList(List<EspacioDto> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of();
        }
        return dtoList.stream()
                .map(EspacioConverter::toVO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de {@link EspacioVO} a una lista de {@link EspacioDto}.
     * 
     * @param voList la lista de VOs a convertir.
     * @return una lista de DTOs equivalente, o una lista vacía si la entrada es {@code null} o vacía.
     */
    public static List<EspacioDto> toDtoList(List<EspacioVO> voList) {
        if (voList == null || voList.isEmpty()) {
            return List.of();
        }
        return voList.stream()
                .map(EspacioConverter::toDto)
                .collect(Collectors.toList());
    }
}
