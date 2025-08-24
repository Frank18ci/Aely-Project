package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.service.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vuelos")
@RequiredArgsConstructor
public class VueloController {
    private final VueloService vueloService;

    @GetMapping
    public ResponseEntity<?> listarVuelos() {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.getAllVuelos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVueloPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.getVueloById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearVuelo(@RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.createVuelo(vuelo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.updateVuelo(id, vuelo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
        return ResponseEntity.noContent().build();
    }
}
