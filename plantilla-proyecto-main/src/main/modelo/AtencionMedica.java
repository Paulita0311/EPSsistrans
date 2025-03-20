package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ATENCION_MEDICA")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String diagnostico;
    private String resultados;

    public AtencionMedica() {
        // Constructor por defecto
    }

    public AtencionMedica(String diagnostico, String resultados) {
        this.diagnostico = diagnostico;
        this.resultados = resultados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return diagnostico + "|" + resultados;
    }
}
