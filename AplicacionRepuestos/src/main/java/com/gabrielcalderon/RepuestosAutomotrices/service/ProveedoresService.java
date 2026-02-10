package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Proveedores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedoresService {
    List<Proveedores> getAllProveedores();
    Proveedores saveProveedor(Proveedores proveedor) throws RuntimeException;
    Proveedores getProveedorById(Integer id);
    Proveedores updateProveedores(Integer id, Proveedores proveedor);
    void deleteProveedor(Integer id);
}
