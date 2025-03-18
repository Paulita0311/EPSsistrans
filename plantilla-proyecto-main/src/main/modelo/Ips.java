package modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "IPS")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idIPS;

    private String nombre;
    private String NIT;
    private String direccion;
    private Integer telefono;

    // Relación con Médicos (Una IPS tiene muchos médicos)
    @OneToMany(mappedBy = "ips", cascade = CascadeType.ALL)
    private List<Medico> medicos;

    // Relación con Servicios de Salud (Una IPS presta muchos servicios)
    @ManyToMany
    @JoinTable(
        name = "IPS_SERVICIO_SALUD",
        joinColumns = @JoinColumn(name = "idIPS"),
        inverseJoinColumns = @JoinColumn(name = "idServicio")
    )
    private List<ServicioDeSalud> servicios;
}
