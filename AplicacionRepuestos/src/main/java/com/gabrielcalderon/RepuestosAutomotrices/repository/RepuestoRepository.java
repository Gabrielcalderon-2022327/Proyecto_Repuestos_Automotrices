package com.gabrielcalderon.RepuestosAutomotrices.repository;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
}
