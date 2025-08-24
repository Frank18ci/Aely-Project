package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String icono;
    private String codigoTelefonoPais;
    private boolean estado;

    @OneToMany(mappedBy = "pais")
    private List<Usuario> usuarios;
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;
}
