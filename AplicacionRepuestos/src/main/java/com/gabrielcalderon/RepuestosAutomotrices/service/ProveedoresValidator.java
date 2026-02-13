package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Proveedores;
import com.gabrielcalderon.RepuestosAutomotrices.repository.ProveedoresRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedoresValidator {
    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresValidator(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    public void validar(Proveedores proveedores) {
        String nombre = proveedores.getNombre_proveedor();
        String email = proveedores.getEmail_proveedor();
        Integer telefono = proveedores.getTelefono_proveedor();

        List<Proveedores> listaProveedores= proveedoresRepository.findAll();

        for (Proveedores p : listaProveedores) {
            if (nombre.equals(p.getNombre_proveedor())) {
                throw new IllegalArgumentException("El nombre del proveedor ya existe");
            }
        }

        for (Proveedores p : listaProveedores) {
            if (email.equals(p.getEmail_proveedor())) {
                throw new IllegalArgumentException("El email del proveedor ya existe");
            }
        }

        if (telefono <= 0) {
            throw new IllegalArgumentException("El telefono debe ser un numero mayor a 0");
        }

        if(!email.endsWith("@gmail.com") && !email.endsWith("@outlook.com") && !email.endsWith("@yahoo.com")){
            throw new IllegalArgumentException("El email del proveedor debe tener alguna de estas extensiones: @gmail.com, @yahoo.com, @gmail.com");
        }
    }
}
