package com.gabrielcalderon.RepuestosAutomotrices.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Repuestos")
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repuesto")
    private Integer id;

    @Column(name = "nombre_repuesto")
    @NotNull(message = "El nombre es un campo obligatorio")
    @NotBlank(message =  "El nombre es un campo obligatorio")
    private String nombre_repuesto;

    @Column(name = "categoria_repuesto")
    @NotNull(message = "La categoria del repuesto es un campo obligatorio")
    @NotBlank(message =  "La categoria del repuesto es un campo obligatorio")
    private String categoria_repuesto;

    @Column(name = "precio_compra")
    @NotNull(message = "El precio de compra es un campo obligatorio")
    private Double precio_compra;

    @Column(name = "precio_venta")
    @NotNull(message = "El precio de venta es un campo obligatorio")
    private Double precio_venta;

    @Column(name = "id_proveedor")
    @NotNull(message = "El id del proveedor es un campo obligatorio")
    private Integer id_proveedor;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_repuesto() {
        return nombre_repuesto;
    }
    public void setNombre_repuesto(String nombre_repuesto) {
        this.nombre_repuesto = nombre_repuesto;
    }

    public String getCategoria_repuesto() {
        return categoria_repuesto;
    }
    public void setCategoria_repuesto(String categoria_repuesto) {
        this.categoria_repuesto = categoria_repuesto;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }
    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }
    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }
    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
