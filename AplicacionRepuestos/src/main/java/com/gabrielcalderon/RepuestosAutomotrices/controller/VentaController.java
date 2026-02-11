package com.gabrielcalderon.RepuestosAutomotrices.controller;


import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import com.gabrielcalderon.RepuestosAutomotrices.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService service;
    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return service.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable Integer id) {
        try{
            Venta searchedVenta = service.getVentaById(id);
            return new ResponseEntity<>(searchedVenta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveVenta(@Valid @RequestBody Venta venta) {
        try{
            Venta createdVenta = service.saveVenta(venta);
            return new ResponseEntity<>(createdVenta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@Valid @RequestBody Venta venta, @PathVariable Integer id) {
        try{
            Venta updatedVenta = service.updateVenta(id, venta);
            return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Integer id) {
        try{
            service.deleteVenta(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
