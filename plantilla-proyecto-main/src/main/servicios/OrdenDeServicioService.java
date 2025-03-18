package services;

import model.OrdenDeServicio;
import model.Afiliado;
import model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.OrdenDeServicioRepository;
import repositories.AfiliadoRepository;
import repositories.MedicoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de OrdenDeServicio.
 */
@Service
public class OrdenDeServicioService {

    @Autowired
    private OrdenDeServicioRepository ordenRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public OrdenDeServicio crearOrdenDeServicio(OrdenDeServicio orden) {
        if (orden.getFechaEmision() == null) {
            throw new IllegalArgumentException("La fecha de emisión no puede ser nula");
        }
        // Validar afiliado
        if (orden.getAfiliado() != null) {
            Optional<Afiliado> afi = afiliadoRepository.findById(orden.getAfiliado().getId());
            if (afi.isEmpty()) {
                throw new IllegalArgumentException("El afiliado no existe");
            }
            orden.setAfiliado(afi.get());
        }
        // Validar médico
        if (orden.getMedico() != null) {
            Optional<Medico> med = medicoRepository.findById(orden.getMedico().getId());
            if (med.isEmpty()) {
                throw new IllegalArgumentException("El médico no existe");
            }
            orden.setMedico(med.get());
        }
        return ordenRepository.save(orden);
    }

    public List<OrdenDeServicio> listarOrdenes() {
        return ordenRepository.findAll();
    }

    public OrdenDeServicio obtenerOrden(Long id) {
        Optional<OrdenDeServicio> op = ordenRepository.findById(id);
        return op.orElse(null);
    }

    public OrdenDeServicio actualizarOrden(Long id, OrdenDeServicio nueva) {
        OrdenDeServicio old = obtenerOrden(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe la orden con id=" + id);
        }
        if (nueva.getFechaEmision() == null) {
            throw new IllegalArgumentException("Fecha de emisión inválida");
        }
        old.setFechaEmision(nueva.getFechaEmision());
        old.setEstado(nueva.getEstado());
        // Afiliado
        if (nueva.getAfiliado() != null) {
            Optional<Afiliado> afi = afiliadoRepository.findById(nueva.getAfiliado().getId());
            if (afi.isEmpty()) {
                throw new IllegalArgumentException("Afiliado no existe");
            }
            old.setAfiliado(afi.get());
        } else {
            old.setAfiliado(null);
        }
        // Médico
        if (nueva.getMedico() != null) {
            Optional<Medico> med = medicoRepository.findById(nueva.getMedico().getId());
            if (med.isEmpty()) {
                throw new IllegalArgumentException("Médico no existe");
            }
            old.setMedico(med.get());
        } else {
            old.setMedico(null);
        }
        return ordenRepository.save(old);
    }

    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}
