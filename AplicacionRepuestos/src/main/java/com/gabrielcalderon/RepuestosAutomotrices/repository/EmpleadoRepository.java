package com.gabrielcalderon.RepuestosAutomotrices.repository;


import com.gabrielcalderon.RepuestosAutomotrices.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer> {
}
