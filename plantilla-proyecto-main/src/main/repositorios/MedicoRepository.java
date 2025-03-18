package co.edu.uniandes.dse.olimpiadasandinas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
