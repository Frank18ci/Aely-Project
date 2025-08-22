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
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private boolean estado;

    @OneToMany(mappedBy = "idioma")
    private List<Usuario> usuarios;
    @OneToMany(mappedBy = "idioma")
    private List<Aeropuerto> aeropuertos;
}
