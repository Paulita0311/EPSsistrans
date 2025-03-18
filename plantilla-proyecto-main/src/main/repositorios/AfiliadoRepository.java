package co.edu.uniandes.dse.olimpiadasandinas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import co.edu.uniandes.dse.olimpiadasandinas.entities.Afiliado;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
  
    List<Afiliado> findByNombre(String nombre);
}
