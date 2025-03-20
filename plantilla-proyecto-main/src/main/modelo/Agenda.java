package modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "AGENDA")
public class Agenda {

    @EmbeddedId
    private AgendaPK pk;  // Clave compuesta (IpsMedico + fechaHora)

    private String estado; // Ejemplo adicional

    public Agenda() {
        // Constructor por defecto
    }

    public Agenda(AgendaPK pk, String estado) {
        this.pk = pk;
        this.estado = estado;
    }

    public AgendaPK getPk() {
        return pk;
    }

    public void setPk(AgendaPK pk) {
        this.pk = pk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Agenda [pk=" + pk + ", estado=" + estado + "]";
    }
}
