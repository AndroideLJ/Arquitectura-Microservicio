package com.neoris.userstransaction.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MovimientoRequestDto {

    private BigDecimal valor;

    private String numeroCuenta;
}
