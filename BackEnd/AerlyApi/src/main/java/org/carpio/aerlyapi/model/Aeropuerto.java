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
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    @Column(name = "codigo_iata", unique = true, length = 3)
    private String codigoIata;
    private String ubicacion;
    private String direccion;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado id_estado;
    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @OneToMany(mappedBy = "origen")
    private List<Vuelo> vuelos_origen;
    @OneToMany(mappedBy = "destino")
    private List<Vuelo> vuelos_destino;
}
