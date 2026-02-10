package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Repuesto;
import com.gabrielcalderon.RepuestosAutomotrices.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImplements implements RepuestoService{
    private final RepuestoRepository repository;

    public RepuestoServiceImplements(RepuestoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Repuesto> getAllRepuestos() {
        return repository.findAll();
    }

    @Override
    public Repuesto getRepuestoByID(Integer id) {
        Repuesto repuesto = repository.findById(id).orElse(null);
        if (repuesto == null) {
            throw new IllegalArgumentException("Repuesto no encontrado");
        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) throws RuntimeException {
        return repository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Repuesto repuesto1 = repository.findById(id).orElse(null);
        if (repuesto1 != null) {
            repuesto1.setNombre_repuesto(repuesto.getNombre_repuesto());
            repuesto1.setCategoria_repuesto(repuesto.getCategoria_repuesto());
            repuesto1.setPrecio_compra(repuesto.getPrecio_compra());
            repuesto1.setPrecio_venta(repuesto.getPrecio_venta());
            repuesto1.setId_proveedor(repuesto.getId_proveedor());
        } else{
            throw new IllegalArgumentException("Repuesto no encontrado");
        }
        return repository.save(repuesto1);
    }

    @Override
    public void deleteRepuesto(Integer id) {
        Repuesto repuesto = repository.findById(id).orElse(null);
        if (repuesto == null) {
            throw new IllegalArgumentException("Repuesto no encontrado");
        }
        repository.deleteById(id);

    }
}
