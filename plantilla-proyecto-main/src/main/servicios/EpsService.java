package services;

import modelo.Eps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EpsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EpsService {

    @Autowired
    private EpsRepository epsRepository;

    public List<Eps> listarTodas() {
        return epsRepository.findAll();
    }

    public Optional<Eps> obtenerEpsPorId(Integer id) {
        return epsRepository.findById(id);
    }

    public Eps guardarEps(Eps eps) {
        return epsRepository.save(eps);
    }

    public void eliminarEps(Integer id) {
        epsRepository.deleteById(id);
    }
}
