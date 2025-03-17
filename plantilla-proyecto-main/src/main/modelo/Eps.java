
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = eps)
public class Eps {
    @Id
    @GenerateValue(strategy = Generationtype.AUTO)

    private integer id;
    private String nombre;
    private String direccion;
    private int telefono;

    public Eps(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
    }

    public eps ()
    {;}

    public integer getId() {
        return id;
    }

    public void setId(integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
