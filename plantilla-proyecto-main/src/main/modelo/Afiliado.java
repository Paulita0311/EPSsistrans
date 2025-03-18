package co.edu.uniandes.dse.olimpiadasandinas.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Afiliado extends BaseEntity {

    private String nombre;
    private String tipoDocumento;    
    private String numeroDocumento;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String parentesco;         
    private String tipoAfiliado;       
}
