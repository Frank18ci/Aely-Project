package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Ticket;
import org.carpio.aerlyapi.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<?> listarTickets() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAllTickets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTicketPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicketById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket(ticket));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.updateTicket(id, ticket));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
