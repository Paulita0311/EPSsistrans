package modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "SERVICIO_SALUD")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDeSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idServicio;

    private String nombreServicio;
    private String descripcion;
    private String requisitos;

    // Relación con IPS (Un servicio puede ser prestado por varias IPS)
    @ManyToMany(mappedBy = "servicios")
    private List<Ips> ips;

    // Relación con Órdenes de Servicio (Un servicio puede estar en varias órdenes)
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<OrdenDeServicio> ordenes;
}
