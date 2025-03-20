package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String registro;

    public Medico() {
        // Constructor por defecto
    }

    public Medico(String nombre, String registro) {
        this.nombre = nombre;
        this.registro = registro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRegistro(){
        return registro;
    }

    public void setRegistro(String registro){
        this.registro = registro;
    }

    @Override
    public String toString() {
        return nombre + "|" + registro;
    }
}
