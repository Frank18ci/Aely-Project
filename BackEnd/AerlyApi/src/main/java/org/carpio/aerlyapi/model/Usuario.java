package org.carpio.aerlyapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String correoElectronico;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
    @NotBlank(message = "El/La nombre es obligatorio")
    private String nombres;
    @NotBlank(message = "El/La apellido es obligatorio")
    private String apellidos;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", updatable = false)
    private Date fechaRegistro;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
}
