package co.edu.uniandes.dse.olimpiadasandinas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.olimpiadasandinas.entities.OrdenDeServicio;

@Repository
public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Long> {
}
