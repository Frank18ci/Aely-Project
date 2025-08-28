package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.EstadoAsiento;
import org.carpio.aerlyapi.service.EstadoAsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados-asientos")
@RequiredArgsConstructor
public class EstadoAsientoController {
    private final EstadoAsientoService estadoAsientoService;
    @GetMapping
    public ResponseEntity<?> listarEstadosAsientos(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoAsientoService.getAllEstadoAsientos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstadoAsientoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoAsientoService.getEstadoAsientoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoAsiento(@RequestBody EstadoAsiento estadoAsiento){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoAsientoService.createEstadoAsiento(estadoAsiento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoAsiento(@PathVariable Long id, @RequestBody EstadoAsiento estadoAsiento){
        return ResponseEntity.status(HttpStatus.OK).body(estadoAsientoService.updateEstadoAsiento(id, estadoAsiento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoAsiento(@PathVariable Long id) {
        estadoAsientoService.deleteEstadoAsiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
