package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Empleado;
import com.gabrielcalderon.RepuestosAutomotrices.repository.EmpleadoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpleadosValidator {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadosValidator(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void validar(Empleado empleado){
        String nombreEmpleado = empleado.getNombre_empleado()+empleado.getApellido_empleado();
        String email = empleado.getEmail_empleado();
        List<Empleado> empleados = empleadoRepository.findAll();

        for (Empleado emp : empleados) {
            if (nombreEmpleado.equals( emp.getNombre_empleado()+emp.getApellido_empleado() )){
                throw new IllegalArgumentException("El nombre empleado ya existe");
            }
        }
        for (Empleado emp : empleados) {
            if (email.equals(emp.getEmail_empleado())){
                throw new IllegalArgumentException("El email empleado ya existe");
            }
        }

        if(!email.endsWith("@gmail.com") && !email.endsWith("@outlook.com") && !email.endsWith("@yahoo.com")){
            throw new IllegalArgumentException("El email empleado debe tener alguna de estas extensiones: @gmail.com, @yahoo.com, @gmail.com");
        }
    }
}
