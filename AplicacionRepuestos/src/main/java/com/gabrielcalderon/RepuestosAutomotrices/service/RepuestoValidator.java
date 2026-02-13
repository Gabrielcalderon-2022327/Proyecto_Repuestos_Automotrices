package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Repuesto;
import com.gabrielcalderon.RepuestosAutomotrices.repository.RepuestoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepuestoValidator {
    private final RepuestoRepository repuestoRepository;

    public RepuestoValidator(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    public void validar(Repuesto repuesto){
        Double precioCompra = repuesto.getPrecio_compra();
        Double precioVenta = repuesto.getPrecio_venta();
        String nombre = repuesto.getNombre_repuesto();
        List<Repuesto> repuestos = repuestoRepository.findAll();

        if(precioCompra <= 0 || precioVenta <= 0){
            throw new IllegalArgumentException("Los precios deben ser mayores a 0");
        }
        if(precioCompra >= precioVenta){
            throw new IllegalArgumentException("El precio de compra no puede ser menor al precio de venta");
        }
        for (Repuesto rp : repuestos) {
            if(nombre.equals(rp.getNombre_repuesto())){
                throw new IllegalArgumentException("El nombre del repuesto ya existe");
            }
        }
    }
}
