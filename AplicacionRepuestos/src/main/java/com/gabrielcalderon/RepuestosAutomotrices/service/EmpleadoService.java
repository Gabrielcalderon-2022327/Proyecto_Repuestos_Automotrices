package com.gabrielcalderon.RepuestosAutomotrices.service;

import com.gabrielcalderon.RepuestosAutomotrices.model.Empleado;
import java.util.List;

public interface EmpleadoService {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(Integer id);
    Empleado saveEmpleado(Empleado empleado) throws RuntimeException;
    Empleado updateEmpleado(Integer id, Empleado empleado);
    void deleateEmpleado(Integer id);
}
