package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Empleado;
import com.gabrielcalderon.RepuestosAutomotrices.exception.ResourceNotFoundException;
import com.gabrielcalderon.RepuestosAutomotrices.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Empleado empleado1 = empleadoRepository.findById(id).orElse(null);
        if (empleado1 != null) {
            empleado1.setNombre_empleado(empleado.getNombre_empleado());
            empleado1.setApellido_empleado(empleado.getApellido_empleado());
            empleado1.setPuesto_empleado(empleado.getPuesto_empleado());
            empleado1.setEmail_empleado(empleado.getEmail_empleado());
        } else {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }
        return empleadoRepository.save(empleado1);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }
        empleadoRepository.deleteById(id);
    }
}
