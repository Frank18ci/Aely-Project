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
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private ModeloAvion modeloAvion;
    @ManyToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @OneToMany(mappedBy = "avion")
    private List<Vuelo> vuelos;
}
