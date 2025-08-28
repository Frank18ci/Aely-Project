package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.EstadoReserva;
import org.carpio.aerlyapi.service.EstadoReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados-reservas")
@RequiredArgsConstructor
public class EstadoReservaController {
    private final EstadoReservaService estadoReservaService;
    @GetMapping
    public ResponseEntity<?> listarEstadosReservas(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoReservaService.getAllEstadoReservas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findEstadoReservaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoReservaService.getEstadoReservaById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoReserva(@RequestBody EstadoReserva estadoReserva){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoReservaService.createEstadoReserva(estadoReserva));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoReserva(@PathVariable Long id, @RequestBody EstadoReserva estadoReserva){
        return ResponseEntity.status(HttpStatus.OK).body(estadoReservaService.updateEstadoReserva(id, estadoReserva));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoReserva(@PathVariable Long id) {
        estadoReservaService.deleteEstadoReserva(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
