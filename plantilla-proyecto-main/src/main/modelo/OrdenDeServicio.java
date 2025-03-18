package co.edu.uniandes.dse.olimpiadasandinas.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class OrdenDeServicio extends BaseEntity {

    private Date fechaEmision;
    private String estado; 

    @ManyToOne
    private AfiliadoEntity afiliado;

    @ManyToOne
    private MedicoEntity medico;

 
}
