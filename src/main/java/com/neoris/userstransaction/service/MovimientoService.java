package com.neoris.userstransaction.service;

import com.neoris.userstransaction.dto.ListarMovimientoDto;
import com.neoris.userstransaction.dto.MovimientoRequestDto;
import com.neoris.userstransaction.entity.Cuenta;
import com.neoris.userstransaction.entity.Movimiento;
import com.neoris.userstransaction.entity.TipoMovimiento;
import com.neoris.userstransaction.mapper.MovimientoMapper;
import com.neoris.userstransaction.repository.CuentaRepository;
import com.neoris.userstransaction.repository.MovimientoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    public MovimientoRepository movimientoRepository;

    @Autowired
    public CuentaRepository cuentaRepository;

    public Integer realizarMovimiento(MovimientoRequestDto movimientoRequestDto) {
        Optional<Cuenta> cuentaDB = cuentaRepository.findByNumero(movimientoRequestDto.getNumeroCuenta());
        if (cuentaDB.isPresent()) {
            Cuenta cuenta = cuentaDB.get();



            TipoMovimiento tipoMovimiento = movimientoRequestDto.getValor().compareTo(BigDecimal.ZERO) < 0   ? TipoMovimiento.RETIRO : TipoMovimiento.DEPOSITO;
            boolean tieneSaldo = cuenta.getSaldo().compareTo(BigDecimal.ZERO) == 1 &&
                    cuenta.getSaldo().compareTo(movimientoRequestDto.getValor().multiply(new BigDecimal(-1))) > -1;
            if( tipoMovimiento.name().equals(TipoMovimiento.RETIRO.name()) && !tieneSaldo){
                throw new IllegalStateException("Saldo no disponible");
            }
            cuenta.setSaldo(cuenta.getSaldo().add(movimientoRequestDto.getValor()));

            cuentaRepository.save(cuenta);
            Movimiento movimiento = Movimiento.builder()
                    .idCuenta(cuenta.getId())
                    .valor(movimientoRequestDto.getValor())
                    .saldo(cuenta.getSaldo())
                    .fecha(LocalDate.now())
                    .tipo(tipoMovimiento).build();
            return movimientoRepository.save(movimiento).getId();
        }
        throw new IllegalStateException("La cuenta a la que desea realizar el movimiento no existe");
    }

    public List<ListarMovimientoDto> consultarMovimientosPorCliente(Integer idCliente, LocalDate fechaInicio, LocalDate fechaFin){
        var list = this.movimientoRepository.findByClienteAndFecha(idCliente,fechaInicio, fechaFin);
        return MovimientoMapper.INSTANCE.toListarMovimientoDto(list);
    }
}
