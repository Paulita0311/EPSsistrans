package services;

import model.Medico;
import model.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MedicoRepository;
import repositories.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Medico.
 */
@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Medico crearMedico(Medico medico) {
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del médico no puede ser vacío");
        }
        // Validar especialidad si viene
        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalArgumentException("La especialidad con ese id no existe");
            }
            medico.setEspecialidad(op.get());
        }
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico obtenerMedico(Long id) {
        Optional<Medico> op = medicoRepository.findById(id);
        return op.orElse(null);
    }

    public Medico actualizarMedico(Long id, Medico medico) {
        Medico old = obtenerMedico(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe el médico con id=" + id);
        }
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        old.setNombre(medico.getNombre());
        old.setTipoDocumento(medico.getTipoDocumento());
        old.setNumeroDocumento(medico.getNumeroDocumento());
        // Actualizar especialidad
        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalArgumentException("Especialidad no existe");
            }
            old.setEspecialidad(op.get());
        } else {
            old.setEspecialidad(null);
        }
        return medicoRepository.save(old);
    }

    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
