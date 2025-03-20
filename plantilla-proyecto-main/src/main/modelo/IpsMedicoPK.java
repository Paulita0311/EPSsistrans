package modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class IpsMedicoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_IPS", referencedColumnName = "id")
    private Ips ips;

    @ManyToOne
    @JoinColumn(name = "ID_EPS", referencedColumnName = "id")
    private Eps eps;

    @ManyToOne
    @JoinColumn(name = "ID_MEDICO", referencedColumnName = "id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "id")
    private ServicioDeSalud servicio;

    public IpsMedicoPK() {
        super();
    }

    public IpsMedicoPK(Ips ips, Eps eps, Medico medico, ServicioDeSalud servicio) {
        super();
        this.ips = ips;
        this.eps = eps;
        this.medico = medico;
        this.servicio = servicio;
    }

    // Getters y Setters ...
}
