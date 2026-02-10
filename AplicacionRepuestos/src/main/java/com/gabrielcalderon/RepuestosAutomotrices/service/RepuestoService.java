package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Repuesto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestoService {
    List<Repuesto> getAllRepuestos();
    Repuesto getRepuestoByID(Integer id);
    Repuesto saveRepuesto(Repuesto repuesto) throws RuntimeException;
    Repuesto updateRepuesto(Integer id, Repuesto repuesto);
    void deleteRepuesto(Integer id);
}
