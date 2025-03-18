package services;

import model.ServicioDeSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ServicioDeSaludRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de ServicioDeSalud.
 */
@Service
public class ServicioDeSaludService {

    @Autowired
    private ServicioDeSaludRepository servicioRepository;

    public List<ServicioDeSalud> listarTodos() {
        return servicioRepository.findAll();
    }

    public Optional<ServicioDeSalud> obtenerServicioPorId(Integer id) {
        return servicioRepository.findById(id);
    }

    public ServicioDeSalud guardarServicio(ServicioDeSalud servicio) {
        if (servicio.getNombreServicio() == null || servicio.getNombreServicio().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio no puede ser nulo o vacío.");
        }
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
