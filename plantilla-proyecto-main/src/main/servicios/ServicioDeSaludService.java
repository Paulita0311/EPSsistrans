package services;

import modelo.ServicioDeSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ServicioDeSaludRepository;

import java.util.List;
import java.util.Optional;

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
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
