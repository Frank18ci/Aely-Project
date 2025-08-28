package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.EstadoPago;
import org.carpio.aerlyapi.service.EstadoPagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados-pagos")
@RequiredArgsConstructor
public class EstadoPagoController {
    private final EstadoPagoService estadoPagoService;
    @GetMapping
    public ResponseEntity<?> listarEstadosPagos(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoPagoService.getAllEstadoPagos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findEstadoPagoById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoPagoService.getEstadoPagoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoPago(@RequestBody EstadoPago estadoPago){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoPagoService.createEstadoPago(estadoPago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoPago(@PathVariable Long id, @RequestBody EstadoPago estadoPago){
        return ResponseEntity.status(HttpStatus.OK).body(estadoPagoService.updateEstadoPago(id, estadoPago));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoPago(@PathVariable Long id) {
        estadoPagoService.deleteEstadoPago(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
