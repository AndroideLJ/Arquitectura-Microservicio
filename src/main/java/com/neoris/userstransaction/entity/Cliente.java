package com.neoris.userstransaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cliente extends Persona {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String password;

    private Boolean estado = Boolean.TRUE;


}
