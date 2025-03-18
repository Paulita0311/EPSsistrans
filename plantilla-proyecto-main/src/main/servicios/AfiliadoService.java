package co.edu.uniandes.dse.olimpiadasandinas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Afiliado;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.olimpiadasandinas.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.olimpiadasandinas.repositories.AfiliadoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Transactional
    public Afiliado createAfiliado(Afiliado afiliado) throws IllegalOperationException {
        log.info("Inicia creación de Afiliado");
        if (afiliado.getNombre() == null || afiliado.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("El nombre del afiliado no puede ser nulo o vacío.");
        }
    

        return afiliadoRepository.save(afiliado);
    }

    @Transactional
    public List<Afiliado> getAfiliados() {
        log.info("Consultando todos los afiliados");
        return afiliadoRepository.findAll();
    }

    @Transactional
    public Afiliado getAfiliado(Long id) throws EntityNotFoundException {
        Optional<Afiliado> op = afiliadoRepository.findById(id);
        if (op.isEmpty()) {
            throw new EntityNotFoundException("Afiliado no encontrado");
        }
        return op.get();
    }

    @Transactional
    public Afiliado updateAfiliado(Long id, Afiliado afiliado)
            throws EntityNotFoundException, IllegalOperationException {
        Afiliado old = getAfiliado(id);

        if (afiliado.getNombre() == null || afiliado.getNombre().trim().isEmpty()) {
            throw new IllegalOperationException("Nombre inválido.");
        }
        old.setNombre(afiliado.getNombre());
        old.setTipoDocumento(afiliado.getTipoDocumento());
        old.setNumeroDocumento(afiliado.getNumeroDocumento());
        old.setFechaNacimiento(afiliado.getFechaNacimiento());
        old.setDireccion(afiliado.getDireccion());
        old.setTelefono(afiliado.getTelefono());
        old.setParentesco(afiliado.getParentesco());
        old.setTipoAfiliado(afiliado.getTipoAfiliado());

        return afiliadoRepository.save(old);
    }

    @Transactional
    public void deleteAfiliado(Long id) throws EntityNotFoundException {
        Afiliado existing = getAfiliado(id);
        afiliadoRepository.delete(existing);
    }
}
