package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "modelo_avion")
public class ModeloAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private int capacidad;
    @Column(precision = 10, scale = 2)
    private BigDecimal peso;

    @OneToMany(mappedBy = "modeloAvion")
    private List<Avion> aviones;

}
