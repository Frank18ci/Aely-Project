package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Aerolinea;
import org.carpio.aerlyapi.service.AerolineaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aerolineas")
@RequiredArgsConstructor
public class AerolineaController {
    private final AerolineaService aerolineaService;

    @GetMapping
    public ResponseEntity<?> listarAerolineas() {
        return ResponseEntity.status(HttpStatus.OK).body(aerolineaService.getAllAerolineas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAerolineaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(aerolineaService.getAerolineaById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearAerolinea(@RequestBody Aerolinea aerolinea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aerolineaService.createAerolinea(aerolinea));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAerolinea(@PathVariable Long id, @RequestBody Aerolinea aerolinea) {
        return ResponseEntity.status(HttpStatus.OK).body(aerolineaService.updateAerolinea(id, aerolinea));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAerolinea(@PathVariable Long id) {
        aerolineaService.deleteAerolinea(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
