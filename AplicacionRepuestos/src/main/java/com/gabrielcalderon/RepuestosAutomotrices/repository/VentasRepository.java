package com.gabrielcalderon.RepuestosAutomotrices.repository;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Venta, Integer> {
}
