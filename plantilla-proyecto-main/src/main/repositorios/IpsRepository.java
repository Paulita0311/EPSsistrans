package repositories;

import modelo.Ips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpsRepository extends JpaRepository<Ips, Integer> {
}
