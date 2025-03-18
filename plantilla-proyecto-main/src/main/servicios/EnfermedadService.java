package services;

import model.Enfermedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EnfermedadRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Enfermedad.
 */
@Service
public class EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public Enfermedad crearEnfermedad(Enfermedad enfermedad) {
        if (enfermedad.getNombreEnfermedad() == null || enfermedad.getNombreEnfermedad().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la enfermedad no puede ser vacío.");
        }
        return enfermedadRepository.save(enfermedad);
    }

    public List<Enfermedad> listarEnfermedades() {
        return enfermedadRepository.findAll();
    }

    public Enfermedad obtenerEnfermedad(Long id) {
        Optional<Enfermedad> op = enfermedadRepository.findById(id);
        return op.orElse(null);
    }

    public Enfermedad actualizarEnfermedad(Long id, Enfermedad enfermedad) {
        Enfermedad old = obtenerEnfermedad(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe una enfermedad con id=" + id);
        }
        if (enfermedad.getNombreEnfermedad() == null || enfermedad.getNombreEnfermedad().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        old.setNombreEnfermedad(enfermedad.getNombreEnfermedad());
        old.setDescripcion(enfermedad.getDescripcion());
        old.setSintomas(enfermedad.getSintomas());
        return enfermedadRepository.save(old);
    }

    public void eliminarEnfermedad(Long id) {
        enfermedadRepository.deleteById(id);
    }
}
