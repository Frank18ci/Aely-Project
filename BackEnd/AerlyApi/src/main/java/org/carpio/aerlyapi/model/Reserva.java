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
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_reserva", updatable = false)
    private Date fechaReserva;
    @ManyToOne
    @JoinColumn(name = "id_estado_reserva")
    private EstadoReserva estadoReserva;
    @OneToMany(mappedBy = "reserva")
    private List<Pago> pagos;

}
