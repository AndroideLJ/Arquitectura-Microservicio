package com.neoris.userstransaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    private LocalDate edad;

    @Column(unique = true)
    private String identificacion;

    private String direccion;

    @Column(unique = true)
    private String telefono;


}
