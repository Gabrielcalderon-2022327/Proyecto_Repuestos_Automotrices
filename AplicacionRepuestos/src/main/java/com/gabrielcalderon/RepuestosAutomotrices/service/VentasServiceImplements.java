package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import com.gabrielcalderon.RepuestosAutomotrices.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentaService{
    private final VentasRepository repository;

    public VentasServiceImplements(VentasRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venta> getAllVentas() {
        return repository.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) {
        Venta venta = repository.findById(id).orElse(null);
        if (venta == null){
            throw new IllegalArgumentException("No se encontro la venta");
        }
        return venta;
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer id, Venta venta) {
        Venta venta1 = repository.findById(id).orElse(null);
        if (venta1 == null){
            throw new IllegalArgumentException("No se encontro la venta");
        } else {
            venta1.setFecha_venta(venta.getFecha_venta());
            venta1.setCantidad(venta.getCantidad());
            venta1.setId_empleado(venta.getId_empleado());
            venta1.setTotal(venta.getTotal());
            venta.setId_repuesto(venta.getId_repuesto());
        }
        return repository.save(venta1);
    }

    @Override
    public void deleteVenta(Integer id) {
        Venta venta = repository.findById(id).orElse(null);
        if (venta == null){
            throw new IllegalArgumentException("No se encontro la venta");
        }
        repository.deleteById(id);
    }
}
