package com.neoris.userstransaction.service;

import com.neoris.userstransaction.dto.ActualizarClienteDto;
import com.neoris.userstransaction.dto.ClienteResponseDto;
import com.neoris.userstransaction.dto.CrearClienteDto;
import com.neoris.userstransaction.entity.Cliente;
import com.neoris.userstransaction.mapper.ClienteMapper;
import com.neoris.userstransaction.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Integer crearCliente (CrearClienteDto crearClienteDto){
        Cliente clienteDB = clienteRepository.save(ClienteMapper.INSTANCE.toEntity(crearClienteDto));
        return clienteDB.getId();
    }

    public void eliminarCliente(Integer id){
        clienteRepository.deleteById(id);
    }

    public List<ClienteResponseDto> listarCliente(){
        return ClienteMapper.INSTANCE.toDto(clienteRepository.findAll());
    }

    public ClienteResponseDto buscarPorId(Integer id){
        return ClienteMapper.INSTANCE.toDto(clienteRepository.findById(id).get());
    }

    public void actualizarCliente(Integer id, ActualizarClienteDto actualizarClienteDto) {
        actualizarClienteDto.setId(id);
        clienteRepository.save(ClienteMapper.INSTANCE.toEntity(actualizarClienteDto));
    }
}
