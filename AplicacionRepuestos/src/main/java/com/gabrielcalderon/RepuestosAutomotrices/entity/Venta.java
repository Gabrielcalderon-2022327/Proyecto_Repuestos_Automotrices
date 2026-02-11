package com.gabrielcalderon.RepuestosAutomotrices.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id_venta;

    @Column(name = "fecha_venta")
    @NotNull(message = "La fecha de venta es un campo obligatorio")
    private LocalDate fecha_venta;

    @Column(name = "cantidad")
    @NotNull(message = "La cantidad de venta es un campo obligatorio")
    private Integer cantidad;

    @Column(name = "total")
    @NotNull(message = "El total es un campo obligatorio")
    private Double total;

    @Column(name = "id_empleado")
    @NotNull(message = "El id del empleado es un campo obligatorio")
    private Integer id_empleado;

    @Column(name = "id_repuesto")
    @NotNull(message = "El id del repuesto es un campo obligatorio")
    private Integer id_repuesto;

    public Integer getId_venta() {
        return id_venta;
    }
    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }
    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Integer getId_repuesto() {
        return id_repuesto;
    }
    public void setId_repuesto(Integer id_repuesto) {
        this.id_repuesto = id_repuesto;
    }
}
