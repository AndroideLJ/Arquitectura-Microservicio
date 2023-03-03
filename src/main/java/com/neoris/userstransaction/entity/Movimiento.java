package com.neoris.userstransaction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha = LocalDate.now();

    @Enumerated(value = EnumType.STRING)
    private TipoMovimiento tipo;

    private BigDecimal valor;

    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn (name = "idCuenta", insertable = false, updatable = false)
    private Cuenta cuenta;

    @Column(name = "idCuenta")
    private Integer idCuenta;


}
