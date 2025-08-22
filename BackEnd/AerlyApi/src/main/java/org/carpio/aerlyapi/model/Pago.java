package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @Column(scale = 10, precision = 2)
    private BigDecimal monto;
    private String moneda;
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pago", updatable = false)
    private Date fechaPago;
    @ManyToOne
    @JoinColumn(name = "id_estado_pago")
    private EstadoPago estadoPago;
}
