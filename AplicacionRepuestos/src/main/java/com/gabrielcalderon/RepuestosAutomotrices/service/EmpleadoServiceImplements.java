package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.model.Empleado;
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
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        return empleadoRepository.save(empleado1);
    }

    @Override
    public void deleateEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
