package co.edu.uniandes.dse.olimpiadasandinas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.olimpiadasandinas.entities.OrdenDeServicio;
import co.edu.uniandes.dse.olimpiadasandinas.entities.Afiliado;
import co.edu.uniandes.dse.olimpiadasandinas.entities.Medico;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.OrdenDeServicioRepository;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.AfiliadoRepository;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdenDeServicioService {

    @Autowired
    private OrdenDeServicioRepository ordenRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public OrdenDeServicio createOrdenDeServicio(OrdenDeServicio orden) throws IllegalOperationException {
        log.info("Inicia creación de OrdenDeServicio");
        if (orden.getFechaEmision() == null) {
            throw new IllegalOperationException("La fecha de emisión no puede ser nula");
        }
       
        if (orden.getAfiliado() != null) {
            Optional<Afiliado> afiOp = afiliadoRepository.findById(orden.getAfiliado().getId());
            if (afiOp.isEmpty()) {
                throw new IllegalOperationException("Afiliado no existe");
            }
            orden.setAfiliado(afiOp.get());
        }
      
        if (orden.getMedico() != null) {
            Optional<Medico> medOp = medicoRepository.findById(orden.getMedico().getId());
            if (medOp.isEmpty()) {
                throw new IllegalOperationException("Médico no existe");
            }
            orden.setMedico(medOp.get());
        }
        

        return ordenRepository.save(orden);
    }

    @Transactional
    public List<OrdenDeServicio> getOrdenesDeServicio() {
        return ordenRepository.findAll();
    }

    @Transactional
    public OrdenDeServicio getOrdenDeServicio(Long id) throws EntityNotFoundException {
        Optional<OrdenDeServicio> op = ordenRepository.findById(id);
        if (op.isEmpty()) {
            throw new EntityNotFoundException("Orden de servicio no encontrada");
        }
        return op.get();
    }

    @Transactional
    public OrdenDeServicio updateOrdenDeServicio(Long id, OrdenDeServicio nueva)
            throws EntityNotFoundException, IllegalOperationException {
        OrdenDeServicio old = getOrdenDeServicio(id);
        if (nueva.getFechaEmision() == null) {
            throw new IllegalOperationException("Fecha emisión inválida");
        }
        old.setFechaEmision(nueva.getFechaEmision());
        old.setEstado(nueva.getEstado());

       
        if (nueva.getAfiliado() != null) {
            Optional<Afiliado> afiOp = afiliadoRepository.findById(nueva.getAfiliado().getId());
            if (afiOp.isEmpty()) {
                throw new IllegalOperationException("Afiliado no existe");
            }
            old.setAfiliado(afiOp.get());
        } else {
            old.setAfiliado(null);
        }
     
        if (nueva.getMedico() != null) {
            Optional<Medico> medOp = medicoRepository.findById(nueva.getMedico().getId());
            if (medOp.isEmpty()) {
                throw new IllegalOperationException("Médico no existe");
            }
            old.setMedico(medOp.get());
        } else {
            old.setMedico(null);
        }

        return ordenRepository.save(old);
    }

    @Transactional
    public void deleteOrdenDeServicio(Long id) throws EntityNotFoundException {
        OrdenDeServicio old = getOrdenDeServicio(id);
        ordenRepository.delete(old);
    }
}
