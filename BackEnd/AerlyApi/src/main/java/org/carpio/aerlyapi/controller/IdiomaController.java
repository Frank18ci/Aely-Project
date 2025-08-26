package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Idioma;
import org.carpio.aerlyapi.service.IdiomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/idiomas")
public class IdiomaController {
    private final IdiomaService idiomaService;

    @GetMapping
    public ResponseEntity<?> listarIdiomas() {
        return ResponseEntity.status(HttpStatus.OK).body(idiomaService.getAllIdiomas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerIdiomaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(idiomaService.getIdiomaById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearIdioma(@RequestBody Idioma idioma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(idiomaService.createIdioma(idioma));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarIdioma(@PathVariable Long id, @RequestBody Idioma idioma) {
        return ResponseEntity.status(HttpStatus.OK).body(idiomaService.updateIdioma(id, idioma));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarIdioma(@PathVariable Long id) {
        idiomaService.deleteIdioma(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
