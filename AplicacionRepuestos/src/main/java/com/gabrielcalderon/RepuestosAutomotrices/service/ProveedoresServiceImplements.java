package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Proveedores;
import com.gabrielcalderon.RepuestosAutomotrices.exception.ResourceNotFoundException;
import com.gabrielcalderon.RepuestosAutomotrices.repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements implements ProveedoresService{
    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresServiceImplements(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedores saveProveedor(Proveedores proveedor) throws RuntimeException {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    public Proveedores getProveedorById(Integer id) {
        Proveedores proveedor = proveedoresRepository.findById(id).orElse(null);
        if (proveedor == null){
            throw new ResourceNotFoundException("No se encontro el proveedor");
        }
        return proveedoresRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedor) {
        Proveedores proveedor1 = proveedoresRepository.findById(id).orElse(null);
        if (proveedor1 != null){
            proveedor1.setNombre_proveedor(proveedor.getNombre_proveedor());
            proveedor1.setDireccion(proveedor.getEmail_proveedor());
            proveedor1.setTelefono_proveedor(proveedor.getTelefono_proveedor());
            proveedor1.setEmail_proveedor(proveedor.getEmail_proveedor());

            return proveedoresRepository.save(proveedor1);
        } else {
            throw new ResourceNotFoundException("No se encontro el proveedor");
        }
    }

    @Override
    public void deleteProveedor(Integer id) {
        Proveedores proveedor = proveedoresRepository.findById(id).orElse(null);
        if (proveedor == null){
            throw new ResourceNotFoundException("No se encontro el proveedor");
        }
        proveedoresRepository.deleteById(id);
    }
}
