package com.gabrielcalderon.RepuestosAutomotrices.controller;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Empleado;
import com.gabrielcalderon.RepuestosAutomotrices.service.EmpleadoService;
import com.gabrielcalderon.RepuestosAutomotrices.service.EmpleadosValidator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    private final EmpleadosValidator empleadosValidator;

    public EmpleadoController(EmpleadoService empleadoService, EmpleadosValidator empleadosValidator) {
        this.empleadoService = empleadoService;
        this.empleadosValidator = empleadosValidator;
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado){
        try {
            empleadosValidator.validar(empleado);
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado(@Valid @RequestBody Empleado empleado, @PathVariable Integer id){
        try {
            empleadosValidator.validar(empleado);
            Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadosById(@PathVariable Integer id){
        try {
            Empleado searchedEmpleado = empleadoService.getEmpleadoById(id);
            return new ResponseEntity<>(searchedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleadoById(@PathVariable Integer id){
        try {
            empleadoService.deleteEmpleado(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }

    }

}
