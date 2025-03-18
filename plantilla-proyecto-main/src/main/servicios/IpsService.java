package services;

import modelo.Ips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IpsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IpsService {

    @Autowired
    private IpsRepository ipsRepository;

    public List<Ips> listarTodas() {
        return ipsRepository.findAll();
    }

    public Optional<Ips> obtenerIpsPorId(Integer id) {
        return ipsRepository.findById(id);
    }

    public Ips guardarIps(Ips ips) {
        return ipsRepository.save(ips);
    }

    public void eliminarIps(Integer id) {
        ipsRepository.deleteById(id);
    }
}
