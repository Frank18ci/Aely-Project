package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "numero_asiento")
    private String numeroAsiento;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;
    @ManyToOne
    @JoinColumn(name = "id_clase_asiento")
    private ClaseAsiento claseAsiento;
    @ManyToOne
    @JoinColumn(name = "id_estado_asiento")
    private EstadoAsiento estadoAsiento;
}
