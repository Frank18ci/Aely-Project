package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.ModeloAvion;
import org.carpio.aerlyapi.service.ModeloAvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos-aviones")
@RequiredArgsConstructor
public class ModeloAvionController {
    private final ModeloAvionService modeloAvionService;

    @GetMapping
    public ResponseEntity<?> listarModelosAviones() {
        return ResponseEntity.status(HttpStatus.OK).body(modeloAvionService.getAllModelosAvion());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerModeloAvionPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modeloAvionService.getModeloAvionById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearModeloAvion(@RequestBody ModeloAvion modeloAvion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloAvionService.createModeloAvion(modeloAvion));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarModeloAvion(@PathVariable Long id, @RequestBody ModeloAvion modeloAvion) {
        return ResponseEntity.status(HttpStatus.OK).body(modeloAvionService.updateModeloAvion(id, modeloAvion));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarModeloAvion(@PathVariable Long id) {
        modeloAvionService.deleteModeloAvion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
