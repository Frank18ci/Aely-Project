package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @GetMapping
    public ResponseEntity<?> listarReservas() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.getAllReservas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerReservaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.getReservaById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.createReserva(reserva));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.updateReserva(id, reserva));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
