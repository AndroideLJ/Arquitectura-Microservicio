package com.neoris.userstransaction.repository;

import com.neoris.userstransaction.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository <Cuenta, Integer> {

    Optional<Cuenta> findByNumero(String numero);

}
