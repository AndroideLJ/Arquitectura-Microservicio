package com.neoris.userstransaction.dto;

import com.neoris.userstransaction.entity.TipoCuenta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ActualizarCuentaDto {

    private Integer id;

    private BigDecimal saldo;

    private Boolean estado = Boolean.TRUE;

}
