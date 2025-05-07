package com.example.proyectoDam.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.proyectoDam.model.ReservaDto;
import com.example.proyectoDam.model.ReservaVO;

/**
 * Clase de utilidad encargada de convertir entre objetos {@link ReservaDto}
 * y {@link ReservaVO} para separar las capas de presentación y persistencia.
 */
public class ReservaConverter {

    /**
     * Convierte un objeto {@link ReservaDto} en un {@link ReservaVO}.
     *
     * @param dto objeto DTO que contiene los datos de la reserva.
     * @return una nueva instancia de {@link ReservaVO} o {@code null} si el DTO es nulo.
     */
    public static ReservaVO toVO(ReservaDto dto) {
        if (dto == null) {
            return null;
        }
        return new ReservaVO(
                dto.getId(),
                dto.getIdUsuario(),
                dto.getIdEspacio(),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                dto.getEstado()
        );
    }

    /**
     * Convierte un objeto {@link ReservaVO} en un {@link ReservaDto}.
     *
     * @param vo objeto VO que representa la reserva persistida en base de datos.
     * @return una nueva instancia de {@link ReservaDto} o {@code null} si el VO es nulo.
     */
    public static ReservaDto toDto(ReservaVO vo) {
        if (vo == null) {
            return null;
        }
        return new ReservaDto(
                vo.getId(),
                vo.getIdUsuario(),
                vo.getIdEspacio(),
                vo.getFecha(),
                vo.getHoraInicio(),
                vo.getHoraFin(),
                vo.getEstado()
        );
    }

    /**
     * Convierte una lista de {@link ReservaDto} en una lista de {@link ReservaVO}.
     *
     * @param dtoList lista de objetos DTO.
     * @return lista equivalente de objetos VO, o lista vacía si la entrada es nula o vacía.
     */
    public static List<ReservaVO> toVOList(List<ReservaDto> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of();
        }
        return dtoList.stream()
                .map(ReservaConverter::toVO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de {@link ReservaVO} en una lista de {@link ReservaDto}.
     *
     * @param voList lista de objetos VO.
     * @return lista equivalente de objetos DTO, o lista vacía si la entrada es nula o vacía.
     */
    public static List<ReservaDto> toDtoList(List<ReservaVO> voList) {
        if (voList == null || voList.isEmpty()) {
            return List.of();
        }
        return voList.stream()
                .map(ReservaConverter::toDto)
                .collect(Collectors.toList());
    }
}
