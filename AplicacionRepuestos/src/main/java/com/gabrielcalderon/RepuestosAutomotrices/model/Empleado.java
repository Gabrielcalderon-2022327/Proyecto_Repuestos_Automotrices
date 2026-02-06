package com.gabrielcalderon.RepuestosAutomotrices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
//Clase anotada que representa una tabla en una base de datos relacional, actua como un puente entre la POO y SQL(JPA Hibernate), permitiendo mapear automaticamente atributos a columnas
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Column(name = "nombre_empleado")
    @NotBlank(message = "El nombre es un campo obligatorio")
    @NotNull(message = "El nombre es un campo obligatorio")
    private String nombre_empleado;

    @Column(name = "apellido_empleado")
    @NotBlank(message = "El apellido es un campo obligatorio")
    @NotNull(message = "El apellido es un campo obligatorio")
    private String apellido_empleado;

    @Column(name = "puesto_empleado")
    @NotBlank(message = "El puesto es un campo obligatorio")
    @NotNull(message = "El puesto es un campo obligatorio")
    private String puesto_empleado;

    @Column(name = "email_empleado")
    @NotBlank(message = "El email es un campo obligatorio")
    @NotNull(message = "El email es un campo obligatorio")
    private String email_empleado;


    // GETTER Y SETTER
    public Integer getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }
    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }
    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getPuesto_empleado() {
        return puesto_empleado;
    }
    public void setPuesto_empleado(String puesto_empleado) {
        this.puesto_empleado = puesto_empleado;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }
    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }
}
