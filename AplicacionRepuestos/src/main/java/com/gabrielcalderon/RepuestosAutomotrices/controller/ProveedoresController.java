package com.gabrielcalderon.RepuestosAutomotrices.controller;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Proveedores;
import com.gabrielcalderon.RepuestosAutomotrices.service.ProveedoresService;
import com.gabrielcalderon.RepuestosAutomotrices.service.ProveedoresValidator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    private final ProveedoresService proveedoresService;
    private final ProveedoresValidator proveedoresValidator;

    public ProveedoresController(ProveedoresService proveedoresService, ProveedoresValidator proveedoresValidator) {
        this.proveedoresService = proveedoresService;
        this.proveedoresValidator = proveedoresValidator;
    }

    @GetMapping
    public List<Proveedores> getAllProveedores(){
        return proveedoresService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProveedorById(@PathVariable Integer id){
        try {
            Proveedores proveedor = proveedoresService.getProveedorById(id);
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }

    }

    @PostMapping
    public ResponseEntity<Object> saveProveedor(@Valid @RequestBody Proveedores proveedor){
        try {
            proveedoresValidator.validar(proveedor);
            Proveedores createdProveedor = proveedoresService.saveProveedor(proveedor);
            return new ResponseEntity<>(createdProveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@Valid @RequestBody Proveedores proveedor, @PathVariable Integer id){
        try{
            proveedoresValidator.validar(proveedor);
            Proveedores updatedProveedor = proveedoresService.updateProveedores(id, proveedor);
            return new ResponseEntity<>(updatedProveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id){
        try {
            proveedoresService.deleteProveedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }
}
