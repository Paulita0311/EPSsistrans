package modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ATENCION_MEDICA")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAtencion;

    private LocalDateTime fecha;
    private String receta;
    private String diagnostico;

    // Relación con Afiliado (Cada atención médica es para un afiliado)
    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Afiliado afiliado;

    // Relación con Médico (Cada atención médica es realizada por un médico)
    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    // Relación con IPS (Cada atención médica ocurre en una IPS)
    @ManyToOne
    @JoinColumn(name = "idIPS")
    private Ips ips;

    // Relación con Servicio de Salud (Cada atención médica corresponde a un servicio)
    @ManyToOne
    @JoinColumn(name = "idServicioSalud")
    private ServicioDeSalud servicio;
}
