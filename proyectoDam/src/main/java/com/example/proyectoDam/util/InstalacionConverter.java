package com.example.proyectoDam.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.proyectoDam.model.InstalacionDto;
import com.example.proyectoDam.model.InstalacionVO;

/**
 * Clase de utilidad encargada de convertir entre objetos {@link InstalacionDto}
 * y {@link InstalacionVO} para separar las capas de presentación y persistencia.
 */
public class InstalacionConverter {

    /**
     * Convierte un objeto {@link InstalacionDto} en un {@link InstalacionVO}.
     *
     * @param dto objeto DTO que contiene los datos de la instalación.
     * @return una nueva instancia de {@link InstalacionVO} o {@code null} si el DTO es nulo.
     */
    public static InstalacionVO toVO(InstalacionDto dto) {
        if (dto == null) {
            return null;
        }
        return new InstalacionVO(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getIdAdministrador(),
                dto.getIdsUsuariosPermitidos()
        );
    }

    /**
     * Convierte un objeto {@link InstalacionVO} en un {@link InstalacionDto}.
     *
     * @param vo objeto VO que representa la instalación persistida en base de datos.
     * @return una nueva instancia de {@link InstalacionDto} o {@code null} si el VO es nulo.
     */
    public static InstalacionDto toDto(InstalacionVO vo) {
        if (vo == null) {
            return null;
        }
        return new InstalacionDto(
                vo.getId(),
                vo.getNombre(),
                vo.getDescripcion(),
                vo.getIdAdministrador(),
                vo.getIdsUsuariosPermitidos()
        );
    }

    /**
     * Convierte una lista de {@link InstalacionDto} en una lista de {@link InstalacionVO}.
     *
     * @param dtoList lista de objetos DTO.
     * @return lista equivalente de objetos VO, o lista vacía si la entrada es nula o vacía.
     */
    public static List<InstalacionVO> toVOList(List<InstalacionDto> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of();
        }
        return dtoList.stream()
                .map(InstalacionConverter::toVO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de {@link InstalacionVO} en una lista de {@link InstalacionDto}.
     *
     * @param voList lista de objetos VO.
     * @return lista equivalente de objetos DTO, o lista vacía si la entrada es nula o vacía.
     */
    public static List<InstalacionDto> toDtoList(List<InstalacionVO> voList) {
        if (voList == null || voList.isEmpty()) {
            return List.of();
        }
        return voList.stream()
                .map(InstalacionConverter::toDto)
                .collect(Collectors.toList());
    }
}
