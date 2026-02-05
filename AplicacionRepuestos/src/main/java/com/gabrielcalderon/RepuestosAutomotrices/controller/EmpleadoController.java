package com.gabrielcalderon.RepuestosAutomotrices.controller;

import com.gabrielcalderon.RepuestosAutomotrices.model.Empleado;
import com.gabrielcalderon.RepuestosAutomotrices.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado){
        try {
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return  new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado(@Valid @RequestBody Empleado empleado, @PathVariable Integer id){
        try {
            Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadosById(@PathVariable Integer id){
        try {
            Empleado searchedEmpleado = empleadoService.getEmpleadoById(id);
            return new ResponseEntity<>(searchedEmpleado, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleadoById(@PathVariable Integer id){
        try {
            empleadoService.deleateEmpleado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
