package co.edu.uniandes.dse.olimpiadasandinas.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Especialidad extends BaseEntity {

    private String nombre;
    private String descripcion;
}
