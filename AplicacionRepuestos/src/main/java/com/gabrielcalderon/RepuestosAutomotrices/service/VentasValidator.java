package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import com.gabrielcalderon.RepuestosAutomotrices.repository.VentasRepository;
import org.springframework.stereotype.Component;

@Component
public class VentasValidator {

    public void validar(Venta venta){
        Integer cantidad =  venta.getCantidad();
        Double total =  venta.getTotal();

        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (total <= 0){
            throw new IllegalArgumentException("El total debe ser mayor a 0");
        }
    }
}
