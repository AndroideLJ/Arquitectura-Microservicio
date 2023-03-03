package com.neoris.userstransaction.mapper;


import com.neoris.userstransaction.dto.ListarMovimientoDto;
import com.neoris.userstransaction.entity.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovimientoMapper {
    MovimientoMapper INSTANCE = Mappers.getMapper(MovimientoMapper.class);

    List<ListarMovimientoDto> toListarMovimientoDto(List<Movimiento> movimientos);


    @Mapping(target = "cliente", source = "movimiento.cuenta.cliente.nombre")
    @Mapping(target = "numero", source = "movimiento.cuenta.numero")
    @Mapping(target = "saldoInicial", source = "movimiento", qualifiedByName = "calcularSaldoInicial")
    @Mapping(target = "estado", source = "movimiento.cuenta.estado")
    @Mapping(target = "movimiento", source = "movimiento.valor")
    @Mapping(target = "saldoDisponible", source = "movimiento.cuenta.saldo")
    ListarMovimientoDto toListarMovimientoDto(Movimiento movimiento);

    @Named("calcularSaldoInicial")
    default BigDecimal calcularSaldoInicial(Movimiento movimiento){
        return movimiento.getSaldo().subtract(movimiento.getValor());
    }



}
