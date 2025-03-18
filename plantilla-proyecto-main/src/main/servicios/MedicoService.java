package co.edu.uniandes.dse.olimpiadasandinas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Medico;
import co.edu.uniandes.dse.olimpiadasandinas.entities.Especialidad;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.MedicoRepository;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.EspecialidadRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public Medico createMedico(Medico medico) throws IllegalOperationException {
        log.info("Inicia proceso de creación de Médico");
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("El nombre del médico no puede ser vacío");
        }
        // Validar si hay especialidad
        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalOperationException("La especialidad no existe");
            }
            medico.setEspecialidad(op.get());
        }
        return medicoRepository.save(medico);
    }

    @Transactional
    public List<Medico> getMedicos() {
        return medicoRepository.findAll();
    }

    @Transactional
    public Medico getMedico(Long id) throws EntityNotFoundException {
        Optional<Medico> op = medicoRepository.findById(id);
        if (op.isEmpty()) {
            throw new EntityNotFoundException("Médico no encontrado");
        }
        return op.get();
    }

    @Transactional
    public Medico updateMedico(Long id, Medico medico)
            throws EntityNotFoundException, IllegalOperationException {
        Medico old = getMedico(id);
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("Nombre inválido");
        }
        old.setNombre(medico.getNombre());
        old.setTipoDocumento(medico.getTipoDocumento());
        old.setNumeroDocumento(medico.getNumeroDocumento());

        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalOperationException("Especialidad no existe");
            }
            old.setEspecialidad(op.get());
        } else {
            old.setEspecialidad(null);
        }

        return medicoRepository.save(old);
    }

    @Transactional
    public void deleteMedico(Long id) throws EntityNotFoundException {
        Medico old = getMedico(id);
        medicoRepository.delete(old);
    }
}
