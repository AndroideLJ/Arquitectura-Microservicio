package com.neoris.userstransaction.dto;

import com.neoris.userstransaction.entity.Genero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ClienteResponseDto {

    private Integer id;

    private String nombre;

    private Genero genero;

    private LocalDate edad;

    private String telefono;
}
