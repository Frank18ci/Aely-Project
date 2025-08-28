package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.MetodoPago;
import org.carpio.aerlyapi.service.MetodoPagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos-pagos")
@RequiredArgsConstructor
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;
    @GetMapping
    public ResponseEntity<?> listarMetodosPagos(){
        return ResponseEntity.status(HttpStatus.OK).body(metodoPagoService.getAllMetodoPagos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMetodoPagoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(metodoPagoService.getMetodoPagoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearMetodoPago(@RequestBody MetodoPago metodoPago){
        return ResponseEntity.status(HttpStatus.CREATED).body(metodoPagoService.createMetodoPago(metodoPago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPago){
        return ResponseEntity.status(HttpStatus.OK).body(metodoPagoService.updateMetodoPago(id, metodoPago));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.deleteMetodoPago(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
