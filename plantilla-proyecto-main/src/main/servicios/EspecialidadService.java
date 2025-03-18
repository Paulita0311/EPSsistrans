package services;

import model.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Especialidad.
 */
@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Especialidad crearEspecialidad(Especialidad especialidad) {
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la especialidad no puede ser vacío.");
        }
        return especialidadRepository.save(especialidad);
    }

    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad obtenerEspecialidad(Long id) {
        Optional<Especialidad> op = especialidadRepository.findById(id);
        return op.orElse(null);
    }

    public Especialidad actualizarEspecialidad(Long id, Especialidad especialidad) {
        Especialidad old = obtenerEspecialidad(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe la especialidad con id=" + id);
        }
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        old.setNombre(especialidad.getNombre());
        old.setDescripcion(especialidad.getDescripcion());
        return especialidadRepository.save(old);
    }

    public void eliminarEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }
}
