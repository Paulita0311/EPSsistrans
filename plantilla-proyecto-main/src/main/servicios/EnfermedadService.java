package co.edu.uniandes.dse.olimpiadasandinas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Enfermedad;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.EnfermedadRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    @Transactional
    public Enfermedad createEnfermedad(Enfermedad enfermedad) throws IllegalOperationException {
        log.info("Inicia creación de Enfermedad");
        if (enfermedad.getNombreEnfermedad() == null || enfermedad.getNombreEnfermedad().trim().isEmpty()) {
            throw new IllegalOperationException("El nombre de la enfermedad no puede ser vacío.");
        }
        return enfermedadRepository.save(enfermedad);
    }

    @Transactional
    public List<Enfermedad> getEnfermedades() {
        return enfermedadRepository.findAll();
    }

    @Transactional
    public Enfermedad getEnfermedad(Long id) throws EntityNotFoundException {
        Optional<Enfermedad> op = enfermedadRepository.findById(id);
        if (op.isEmpty()) {
            throw new EntityNotFoundException("Enfermedad no encontrada");
        }
        return op.get();
    }

    @Transactional
    public Enfermedad updateEnfermedad(Long id, Enfermedad enfermedad)
            throws EntityNotFoundException, IllegalOperationException {
        Enfermedad old = getEnfermedad(id);
        if (enfermedad.getNombreEnfermedad() == null || enfermedad.getNombreEnfermedad().trim().isEmpty()) {
            throw new IllegalOperationException("Nombre inválido");
        }
        old.setNombreEnfermedad(enfermedad.getNombreEnfermedad());
        old.setDescripcion(enfermedad.getDescripcion());
        old.setSintomas(enfermedad.getSintomas());
        return enfermedadRepository.save(old);
    }

    @Transactional
    public void deleteEnfermedad(Long id) throws EntityNotFoundException {
        Enfermedad old = getEnfermedad(id);
        enfermedadRepository.delete(old);
    }
}
