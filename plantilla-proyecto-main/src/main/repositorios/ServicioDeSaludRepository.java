package repositories;

import modelo.ServicioDeSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioDeSaludRepository extends JpaRepository<ServicioDeSalud, Integer> {
}
