package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Integer id);
    Venta saveVenta(Venta venta);
    Venta updateVenta(Integer id, Venta venta);
    void deleteVenta(Integer id);
}
