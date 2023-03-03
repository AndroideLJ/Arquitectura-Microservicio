package com.neoris.userstransaction.mapper;

import com.neoris.userstransaction.dto.ActualizarClienteDto;
import com.neoris.userstransaction.dto.ClienteResponseDto;
import com.neoris.userstransaction.dto.CrearClienteDto;
import com.neoris.userstransaction.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    Cliente toEntity (CrearClienteDto clienteDto);

    List<ClienteResponseDto> toDto (List<Cliente> entities);
    ClienteResponseDto toDto (Cliente cliente);
    Cliente toEntity (ActualizarClienteDto actualizarClienteDto);

}
