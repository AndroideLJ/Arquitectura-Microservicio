package com.neoris.userstransaction.service;

import com.neoris.userstransaction.dto.ActualizarCuentaDto;
import com.neoris.userstransaction.dto.CrearCuentaDto;
import com.neoris.userstransaction.entity.Cuenta;
import com.neoris.userstransaction.mapper.CuentaMapper;
import com.neoris.userstransaction.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Integer crearCuenta(CrearCuentaDto crearCuentaDto){
        return cuentaRepository.save(CuentaMapper.INSTANCE.toEntity(crearCuentaDto)).getId();
    }

    public void eliminarCuenta(Integer id){
        cuentaRepository.deleteById(id);
    }

    public void actualizarCuenta(Integer id, ActualizarCuentaDto actualizarCuentaDto){
        Optional <Cuenta> cuentaDB = cuentaRepository.findById(id);
            if(cuentaDB.isPresent()){
                Cuenta cuenta = cuentaDB.get();
                cuenta.setEstado(actualizarCuentaDto.getEstado());
                cuenta.setSaldo(actualizarCuentaDto.getSaldo());
                cuentaRepository.save(cuenta);
            }

    }

}
