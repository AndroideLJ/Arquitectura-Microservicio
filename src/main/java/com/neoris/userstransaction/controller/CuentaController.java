package com.neoris.userstransaction.controller;

import com.neoris.userstransaction.dto.*;
import com.neoris.userstransaction.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<Integer> crearCuenta(@RequestBody CrearCuentaDto crearCuentaDto){
        return ResponseEntity.ok(cuentaService.crearCuenta(crearCuentaDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Integer id){
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> actualizarCuenta(@PathVariable Integer id, @RequestBody ActualizarCuentaDto actualizarCuentaDto){
        cuentaService.actualizarCuenta(id, actualizarCuentaDto);
        return ResponseEntity.ok().build();
    }


}
