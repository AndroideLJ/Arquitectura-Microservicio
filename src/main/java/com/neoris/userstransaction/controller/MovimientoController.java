package com.neoris.userstransaction.controller;

import com.neoris.userstransaction.dto.ListarMovimientoDto;
import com.neoris.userstransaction.dto.MovimientoRequestDto;
import com.neoris.userstransaction.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Integer> crearMovimiento(@RequestBody MovimientoRequestDto movientoRequestDto){
        return ResponseEntity.ok(movimientoService.realizarMovimiento(movientoRequestDto));
    }

    //api/v1/movimientos?fechaInicio=2023-01-01&fechaFin=2023-03-20&idCliente=1
    @GetMapping
    public ResponseEntity<List<ListarMovimientoDto>> consultarMovimientos(@RequestParam Integer idCliente, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin){
        var response = movimientoService.consultarMovimientosPorCliente(idCliente, fechaInicio,fechaFin);
        return ResponseEntity.ok(response);
    }


}
