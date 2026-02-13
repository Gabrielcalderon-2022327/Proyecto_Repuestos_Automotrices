package com.gabrielcalderon.RepuestosAutomotrices.controller;


import com.gabrielcalderon.RepuestosAutomotrices.entity.Venta;
import com.gabrielcalderon.RepuestosAutomotrices.service.VentaService;
import com.gabrielcalderon.RepuestosAutomotrices.service.VentasValidator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService service;
    private final VentasValidator ventasValidator;
    public VentaController(VentaService service, VentasValidator ventasValidator) {
        this.service = service;
        this.ventasValidator = ventasValidator;
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
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveVenta(@Valid @RequestBody Venta venta) {
        try{
            ventasValidator.validar(venta);
            Venta createdVenta = service.saveVenta(venta);
            return new ResponseEntity<>(createdVenta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@Valid @RequestBody Venta venta, @PathVariable Integer id) {
        try{
            ventasValidator.validar(venta);
            Venta updatedVenta = service.updateVenta(id, venta);
            return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Integer id) {
        try{
            service.deleteVenta(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }




}
