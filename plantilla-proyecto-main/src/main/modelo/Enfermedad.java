package co.edu.uniandes.dse.olimpiadasandinas.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class EnfermedadEntity extends BaseEntity {

    private String nombreEnfermedad;
    private String descripcion;
    private String sintomas;
}
