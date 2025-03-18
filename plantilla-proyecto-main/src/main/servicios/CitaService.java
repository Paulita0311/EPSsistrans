package services;

import model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CitaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Cita.
 */
@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerCitaPorId(Integer id) {
        return citaRepository.findById(id);
    }

    public Cita guardarCita(Cita cita) {
        if (cita.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser nula.");
        }
        return citaRepository.save(cita);
    }

    public void eliminarCita(Integer id) {
        citaRepository.deleteById(id);
    }
}
