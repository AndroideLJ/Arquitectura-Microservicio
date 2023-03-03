package com.neoris.userstransaction.mapper;

import com.neoris.userstransaction.dto.ActualizarCuentaDto;
import com.neoris.userstransaction.dto.CrearCuentaDto;
import com.neoris.userstransaction.entity.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaMapper {
    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);
    Cuenta toEntity (CrearCuentaDto crearCuentaDto);

    Cuenta toEntity (ActualizarCuentaDto actualizarCuentaDto);
}
