package com.neoris.userstransaction.dto;

import com.neoris.userstransaction.entity.TipoCuenta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CrearCuentaDto {

    private String numero;

    private TipoCuenta tipo;

    private BigDecimal saldo;

    private Boolean estado = Boolean.TRUE;

    private Integer idCliente;
}
