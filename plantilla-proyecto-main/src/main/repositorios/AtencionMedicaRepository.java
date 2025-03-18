package repositories;

import modelo.AtencionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Integer> {
}
