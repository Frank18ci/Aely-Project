package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "codigo_vuelo")
    private String codigoVuelo;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_salida")
    private Aeropuerto origen;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_llegada")
    private Aeropuerto destino;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_llegada")
    private Date fechaLlegada;
    private int duracion;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_estado_vuelo")
    private EstadoVuelo estadoVuelo;
    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;
    @OneToMany(mappedBy = "vuelo")
    private List<Asiento> asientos;
}
