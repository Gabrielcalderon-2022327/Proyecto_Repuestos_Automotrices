package com.gabrielcalderon.RepuestosAutomotrices.controller;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Proveedores;
import com.gabrielcalderon.RepuestosAutomotrices.service.ProveedoresService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    private final ProveedoresService proveedoresService;

    public ProveedoresController(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
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
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<Object> saveProveedor(@Valid @RequestBody Proveedores proveedor){
        try {
            Proveedores createdProveedor = proveedoresService.saveProveedor(proveedor);
            return new ResponseEntity<>(createdProveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@Valid @RequestBody Proveedores proveedor, @PathVariable Integer id){
        try{
            Proveedores updatedProveedor = proveedoresService.updateProveedores(id, proveedor);
            return new ResponseEntity<>(updatedProveedor, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id){
        try {
            proveedoresService.deleteProveedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
