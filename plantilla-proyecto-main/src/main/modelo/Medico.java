package co.edu.uniandes.dse.olimpiadasandinas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Medico extends BaseEntity {

    private String nombre;
    private String tipoDocumento;   // p.ej. "CC"
    private String numeroDocumento;

    // Relación opcional con Especialidad, si tu modelo lo define:
    @ManyToOne
    private EspecialidadEntity especialidad;
}
