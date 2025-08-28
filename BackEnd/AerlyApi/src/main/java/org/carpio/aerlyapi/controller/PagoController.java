package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Pago;
import org.carpio.aerlyapi.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService pagoService;
    @GetMapping
    public ResponseEntity<?> listarPagos(){
        return ResponseEntity.ok(pagoService.getAllPagos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPagoPorId(@PathVariable Long id){
        return ResponseEntity.ok(pagoService.getPagoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearPago(@RequestBody Pago pago){
        return ResponseEntity.status(201).body(pagoService.createPago(pago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.updatePago(id, pago));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
