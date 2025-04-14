package com.example.proyectoDam.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.proyectoDam.model.UsuarioDto;
import com.example.proyectoDam.model.UsuarioVO;

public class UsuarioConverter {

    // Convertir UsuarioDto a UsuarioVO
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

    // Convertir UsuarioVO a UsuarioDto
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

    // Convertir lista de UsuarioDto a lista de UsuarioVO
    public static List<UsuarioVO> toVOList(List<UsuarioDto> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of(); // Devuelve lista vacía si null o vacía
        }
        return dtoList.stream()
                .map(UsuarioConverter::toVO)
                .collect(Collectors.toList());
    }

    // Convertir lista de UsuarioVO a lista de UsuarioDto
    public static List<UsuarioDto> toDtoList(List<UsuarioVO> voList) {
        if (voList == null || voList.isEmpty()) {
            return List.of(); // Devuelve lista vacía si null o vacía
        }
        return voList.stream()
                .map(UsuarioConverter::toDto)
                .collect(Collectors.toList());
    }
}
