package modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "EPS")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Eps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEPS;

    private String nombre;
    private String direccion;
    private Integer telefono;

    // Relación con Afiliados (Una EPS tiene muchos afiliados)
    @OneToMany(mappedBy = "eps", cascade = CascadeType.ALL)
    private List<Afiliado> afiliados;
}
