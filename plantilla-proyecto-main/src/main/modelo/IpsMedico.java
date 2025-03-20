package modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPS_MEDICO")
public class IpsMedico {

    @EmbeddedId
    private IpsMedicoPK pk;  // Clave compuesta (Ips + Eps + Medico + ServicioDeSalud)

 
    public IpsMedico() {
       
    }

    public IpsMedico(IpsMedicoPK pk) {
        this.pk = pk;
    }

    public IpsMedicoPK getPk() {
        return pk;
    }

    public void setPk(IpsMedicoPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "IpsMedico [pk=" + pk + "]";
    }
}
