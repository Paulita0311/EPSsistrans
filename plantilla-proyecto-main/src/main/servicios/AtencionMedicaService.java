package services;

import modelo.AtencionMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AtencionMedicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtencionMedicaService {

    @Autowired
    private AtencionMedicaRepository atencionRepository;

    public List<AtencionMedica> listarTodas() {
        return atencionRepository.findAll();
    }

    public Optional<AtencionMedica> obtenerAtencionPorId(Integer id) {
        return atencionRepository.findById(id);
    }

    public AtencionMedica guardarAtencion(AtencionMedica atencion) {
        return atencionRepository.save(atencion);
    }

    public void eliminarAtencion(Integer id) {
        atencionRepository.deleteById(id);
    }
}

