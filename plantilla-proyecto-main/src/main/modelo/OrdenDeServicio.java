package modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDEN_BASE")
public class OrdenDeServicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date fechaEmision;
    private Integer idAfiliado;   // o relacion Afiliado
    private Integer idMedico;     // o relacion Medico
    private Integer idServicio;   // o relacion ServicioSalud

    public OrdenDeServicio() {
        // Constructor por defecto
    }

    public OrdenDeServicio(Date fechaEmision, Integer idAfiliado, Integer idMedico, Integer idServicio) {
        this.fechaEmision = fechaEmision;
        this.idAfiliado = idAfiliado;
        this.idMedico = idMedico;
        this.idServicio = idServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Integer idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public String toString() {
        return fechaEmision + "|" + idAfiliado + "|" + idMedico + "|" + idServicio;
    }
}
