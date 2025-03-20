package modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AgendaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_IPS_MEDICO", referencedColumnName = "id")
    private IpsMedico ipsMedico;

    private Timestamp fechaHora;  // O Date, si prefieres

    public AgendaPK() {
        super();
    }

    public AgendaPK(IpsMedico ipsMedico, Timestamp fechaHora) {
        super();
        this.ipsMedico = ipsMedico;
        this.fechaHora = fechaHora;
    }

    public IpsMedico getIpsMedico() {
        return ipsMedico;
    }

    public void setIpsMedico(IpsMedico ipsMedico) {
        this.ipsMedico = ipsMedico;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
}
