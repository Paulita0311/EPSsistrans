package modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CITA")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCita;

    private LocalDateTime fecha;
    private String estado;

    // Relación con Afiliado (Cada cita es para un solo afiliado)
    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Afiliado afiliado;

    // Relación con Médico (Cada cita es atendida por un médico)
    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    // Relación con IPS (Cada cita se atiende en una IPS)
    @ManyToOne
    @JoinColumn(name = "idIPS")
    private Ips ips;
}
