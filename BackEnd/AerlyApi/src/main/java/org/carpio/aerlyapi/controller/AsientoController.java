package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Asiento;
import org.carpio.aerlyapi.service.AsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asientos")
@RequiredArgsConstructor
public class AsientoController {
    private final AsientoService asientoService;
    @GetMapping
    public ResponseEntity<?> listarAsientos(){
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAllAsientos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAsientoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAsientoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearAsiento(@RequestBody Asiento asiento){
        return ResponseEntity.status(HttpStatus.CREATED).body(asientoService.createAsiento(asiento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAsiento(@PathVariable Long id, @RequestBody Asiento asiento){
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.updateAsiento(id, asiento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsiento(@PathVariable Long id) {
        asientoService.deleteAsiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
