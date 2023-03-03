package com.neoris.userstransaction.controller;

import com.neoris.userstransaction.dto.ActualizarClienteDto;
import com.neoris.userstransaction.dto.ClienteResponseDto;
import com.neoris.userstransaction.dto.CrearClienteDto;
import com.neoris.userstransaction.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarCliente(){
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDto> listarClienteId(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Integer> crearCliente(@RequestBody CrearClienteDto crearClienteDto){
        return ResponseEntity.ok(clienteService.crearCliente(crearClienteDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> actualizarCliente (@PathVariable Integer id, @RequestBody ActualizarClienteDto actualizarClienteDto){
        clienteService.actualizarCliente(id, actualizarClienteDto);
        return ResponseEntity.ok().build();
    }



}
