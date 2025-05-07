package com.example.proyectoDam.util;

import com.example.proyectoDam.model.SolicitudAccesoDto;
import com.example.proyectoDam.model.SolicitudAccesoVO;

import java.util.List;
import java.util.stream.Collectors;

public class SolicitudAccesoConverter {

    public static SolicitudAccesoVO toVO(SolicitudAccesoDto dto) {
        if (dto == null) return null;
        return new SolicitudAccesoVO(
                dto.getId(),
                dto.getIdUsuario(),
                dto.getIdInstalacion(),
                dto.getEstado(),
                dto.getFechaSolicitud()
        );
    }

    public static SolicitudAccesoDto toDto(SolicitudAccesoVO vo) {
        if (vo == null) return null;
        return new SolicitudAccesoDto(
                vo.getId(),
                vo.getIdUsuario(),
                vo.getIdInstalacion(),
                vo.getEstado(),
                vo.getFechaSolicitud()
        );
    }

    public static List<SolicitudAccesoDto> toDtoList(List<SolicitudAccesoVO> voList) {
        return voList == null ? List.of() : voList.stream().map(SolicitudAccesoConverter::toDto).collect(Collectors.toList());
    }

    public static List<SolicitudAccesoVO> toVOList(List<SolicitudAccesoDto> dtoList) {
        return dtoList == null ? List.of() : dtoList.stream().map(SolicitudAccesoConverter::toVO).collect(Collectors.toList());
    }
}
