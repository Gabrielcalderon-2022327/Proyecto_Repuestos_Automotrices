package com.gabrielcalderon.RepuestosAutomotrices.controller;

import com.gabrielcalderon.RepuestosAutomotrices.entity.Repuesto;
import com.gabrielcalderon.RepuestosAutomotrices.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {
    private final RepuestoService service;

    public RepuestoController(RepuestoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Repuesto> getAlLService(){
        return service.getAllRepuestos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepuestoById(@PathVariable Integer id){
        try{
            Repuesto searchedRepuesto = service.getRepuestoByID(id);
            return new ResponseEntity<>(searchedRepuesto, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveRepuesto(@Valid @RequestBody Repuesto repuesto){
        try {
            Repuesto savedRepuesto = service.saveRepuesto(repuesto);
            return new ResponseEntity<>(savedRepuesto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepuesto(@Valid @RequestBody Repuesto repuesto, @PathVariable Integer id){
        try{
            Repuesto updatedRepuesto = service.updateRepuesto(id, repuesto);
            return new ResponseEntity<>(updatedRepuesto, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuesto(@PathVariable Integer id){
        try{
            service.deleteRepuesto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
