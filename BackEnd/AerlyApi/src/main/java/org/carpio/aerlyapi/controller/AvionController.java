package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Avion;
import org.carpio.aerlyapi.service.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aviones")
@RequiredArgsConstructor
public class AvionController {
    private final AvionService avionService;
    @GetMapping
    public ResponseEntity<?> listarAviones() {
        return ResponseEntity.status(HttpStatus.OK).body(avionService.getAllAviones());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAvionPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avionService.getAvionById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearAvion(@RequestBody Avion avion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avionService.createAvion(avion));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAvion(@PathVariable Long id, @RequestBody Avion avion) {
        return ResponseEntity.status(HttpStatus.OK).body(avionService.updateAvion(id, avion));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAvion(@PathVariable Long id) {
        avionService.deleteAvion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
