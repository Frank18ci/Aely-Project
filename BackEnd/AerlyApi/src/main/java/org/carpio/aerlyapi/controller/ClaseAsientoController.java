package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.ClaseAsiento;
import org.carpio.aerlyapi.service.ClaseAsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clase-asientos")
@RequiredArgsConstructor
public class ClaseAsientoController {
    private final ClaseAsientoService claseAsientoService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(claseAsientoService.getAllClaseAsientos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(claseAsientoService.getClaseAsientoById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClaseAsiento claseAsiento){
        return ResponseEntity.status(HttpStatus.CREATED).body(claseAsientoService.createClaseAsiento(claseAsiento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClaseAsiento claseAsiento){
        return ResponseEntity.status(HttpStatus.OK).body(claseAsientoService.updateClaseAsiento(id, claseAsiento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        claseAsientoService.deleteClaseAsiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}