package com.example.vehicleinsurestoragesql.controller;

import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.example.vehicleinsurestoragesql.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private IVehicleService service;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> insert(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.insert(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.update(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/plate")
    public ResponseEntity<List<String>> getAllPlates() {
        List<String> plates = service.getAllPlate();
        return new ResponseEntity<>(plates, HttpStatus.OK);
    }

}
