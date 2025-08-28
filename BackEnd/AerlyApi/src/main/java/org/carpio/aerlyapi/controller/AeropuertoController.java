package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.service.AeropuertoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aeropuertos")
@RequiredArgsConstructor
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;
    @GetMapping
    public ResponseEntity<?> listarAeropuertos(){
        return ResponseEntity.status(HttpStatus.OK).body(aeropuertoService.getAllAeropuertos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findAeropuertoById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(aeropuertoService.getAeropuertoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearAeropuerto(@RequestBody Aeropuerto aeropuerto){
        return ResponseEntity.status(HttpStatus.CREATED).body(aeropuertoService.createAeropuerto(aeropuerto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAeropuerto(@PathVariable Long id, @RequestBody Aeropuerto aeropuerto){
        return ResponseEntity.status(HttpStatus.OK).body(aeropuertoService.updateAeropuerto(id, aeropuerto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAeropuerto(@PathVariable Long id) {
        aeropuertoService.deleteAeropuerto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
