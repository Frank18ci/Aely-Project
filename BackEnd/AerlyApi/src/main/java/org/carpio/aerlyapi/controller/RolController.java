package org.carpio.aerlyapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping
    public ResponseEntity<?> getAllRols(){
        return ResponseEntity.status(HttpStatus.OK).body(rolService.getAllRoles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRolById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(rolService.getRolById(id));
    }
    @PostMapping
    public ResponseEntity<?> createRol(@RequestBody @Valid Rol rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.createRol(rol));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRol(@PathVariable Long id, @RequestBody Rol rol){
        return ResponseEntity.status(HttpStatus.OK).body(rolService.updateRol(id, rol));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id){
        rolService.deleteRol(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
