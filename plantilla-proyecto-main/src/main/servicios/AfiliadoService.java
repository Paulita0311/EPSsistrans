package services;

import model.Afiliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.AfiliadoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Afiliado.
 */
@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Transactional
    public Afiliado crearAfiliado(Afiliado afiliado) {
        // Validación de ejemplo
        if (afiliado.getNombre() == null || afiliado.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del afiliado no puede ser nulo o vacío.");
        }
        return afiliadoRepository.save(afiliado);
    }

    @Transactional
    public List<Afiliado> listarAfiliados() {
        return afiliadoRepository.findAll();
    }

    @Transactional
    public Afiliado obtenerAfiliado(Long id) {
        Optional<Afiliado> op = afiliadoRepository.findById(id);
        return op.orElse(null);
    }

    @Transactional
    public Afiliado actualizarAfiliado(Long id, Afiliado afiliado) {
        Afiliado afiliadoExistente = obtenerAfiliado(id);
        if (afiliadoExistente == null) {
            throw new IllegalArgumentException("No existe el afiliado con id=" + id);
        }
        if (afiliado.getNombre() == null || afiliado.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        // Actualizar campos
        afiliadoExistente.setNombre(afiliado.getNombre());
        afiliadoExistente.setTipoDocumento(afiliado.getTipoDocumento());
        afiliadoExistente.setNumeroDocumento(afiliado.getNumeroDocumento());
        afiliadoExistente.setFechaNacimiento(afiliado.getFechaNacimiento());
        afiliadoExistente.setDireccion(afiliado.getDireccion());
        afiliadoExistente.setTelefono(afiliado.getTelefono());
        afiliadoExistente.setParentesco(afiliado.getParentesco());
        afiliadoExistente.setTipoAfiliado(afiliado.getTipoAfiliado());
        return afiliadoRepository.save(afiliadoExistente);
    }

    @Transactional
    public void eliminarAfiliado(Long id) {
        afiliadoRepository.deleteById(id);
    }
}
