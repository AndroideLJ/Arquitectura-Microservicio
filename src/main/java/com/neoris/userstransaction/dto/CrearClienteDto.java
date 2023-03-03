package com.neoris.userstransaction.dto;

import com.neoris.userstransaction.entity.Genero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CrearClienteDto {

    private String nombre;

    private Genero genero;

    private LocalDate edad;

    private String identificacion;

    private String direccion;

    private String telefono;

    private String password;

}
