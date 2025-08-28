package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Pais;
import org.carpio.aerlyapi.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
@RequiredArgsConstructor
public class PaisController {
    private final PaisService paisService;

    @GetMapping
    public ResponseEntity<?> listarPaises() {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.getAllPais());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPaisPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.getPaisById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearPais(@RequestBody Pais pais) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paisService.createPais(pais));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPais(@PathVariable Long id, @RequestBody Pais pais) {
        return ResponseEntity.status(HttpStatus.OK).body(paisService.updatePais(id, pais));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
