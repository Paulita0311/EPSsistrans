package co.edu.uniandes.dse.olimpiadasandinas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Especialidad;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.EspecialidadRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public Especialidad createEspecialidad(Especialidad especialidad) throws IllegalOperationException {
        log.info("Inicia creación de Especialidad");
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("El nombre de la especialidad no puede ser vacío");
        }
        return especialidadRepository.save(especialidad);
    }

    @Transactional
    public List<Especialidad> getEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Transactional
    public Especialidad getEspecialidad(Long id) throws EntityNotFoundException {
        Optional<Especialidad> op = especialidadRepository.findById(id);
        if (op.isEmpty()) {
            throw new EntityNotFoundException("Especialidad no encontrada");
        }
        return op.get();
    }

    @Transactional
    public Especialidad updateEspecialidad(Long id, Especialidad especialidad)
            throws EntityNotFoundException, IllegalOperationException {
        Especialidad old = getEspecialidad(id);
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("Nombre inválido");
        }
        old.setNombre(especialidad.getNombre());
        old.setDescripcion(especialidad.getDescripcion());
        return especialidadRepository.save(old);
    }

    @Transactional
    public void deleteEspecialidad(Long id) throws EntityNotFoundException {
        Especialidad old = getEspecialidad(id);
        especialidadRepository.delete(old);
    }
}
