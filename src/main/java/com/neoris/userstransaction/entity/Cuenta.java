package com.neoris.userstransaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    @Enumerated(value = EnumType.STRING)
    private TipoCuenta tipo;

    private BigDecimal saldo = BigDecimal.ZERO;

    private Boolean estado = Boolean.TRUE;

    @OneToOne
    @JoinColumn (name = "idCliente", insertable = false, updatable = false)
    private Cliente cliente;

    @Column (name = "idCliente")
    private Integer idCliente;

}
