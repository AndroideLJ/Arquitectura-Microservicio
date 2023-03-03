package com.neoris.userstransaction.dto;

import com.neoris.userstransaction.entity.Movimiento;
import com.neoris.userstransaction.entity.TipoCuenta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ListarMovimientoDto {

    private LocalDate fecha;

    private String cliente;

    private String numero;

    //private TipoCuenta tipo;

    private BigDecimal saldoInicial;

    private Boolean estado = Boolean.TRUE;

    private Integer movimiento;

    private Integer saldoDisponible;


}
