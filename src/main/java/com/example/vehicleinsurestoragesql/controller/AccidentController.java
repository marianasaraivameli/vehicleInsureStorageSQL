package com.example.vehicleinsurestoragesql.controller;

import com.example.vehicleinsurestoragesql.dto.AccidentDTO;
import com.example.vehicleinsurestoragesql.model.Accident;
import com.example.vehicleinsurestoragesql.service.IAccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accident")
public class AccidentController {

    @Autowired
    private IAccidentService service;

    @GetMapping
    public ResponseEntity<List<AccidentDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accident> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Accident> insert(@RequestBody Accident accident) {
        return new ResponseEntity<>(service.insert(accident), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accident> update(@RequestBody Accident accident) {
        return new ResponseEntity<>(service.update(accident), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
