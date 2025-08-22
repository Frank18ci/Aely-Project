package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(name = "id_asiento")
    private Asiento asiento;
    @Column(unique = true, name = "codigo_ticket")
    private String codigoTicket;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

}
