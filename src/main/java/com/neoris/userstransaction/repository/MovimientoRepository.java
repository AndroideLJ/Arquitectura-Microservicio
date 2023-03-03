package com.neoris.userstransaction.repository;

import com.neoris.userstransaction.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository <Movimiento, Integer> {

    @Query(value = "SELECT m FROM Movimiento m where m.cuenta.idCliente = :idCliente and m.fecha between :fechaInicio and :fechaFin")
    List<Movimiento> findByClienteAndFecha(Integer idCliente, LocalDate fechaInicio, LocalDate fechaFin);
}
