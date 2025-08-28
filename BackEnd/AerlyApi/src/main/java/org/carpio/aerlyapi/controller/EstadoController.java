package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Estado;
import org.carpio.aerlyapi.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoService estadoService;
    @GetMapping
    public ResponseEntity<?> listarEstados(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.getAllEstados());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstadoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.getEstadoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstado(@RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.createEstado(estado));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstado(@PathVariable Long id, @RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.updateEstado(id, estado));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstado(@PathVariable Long id) {
        estadoService.deleteEstado(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
