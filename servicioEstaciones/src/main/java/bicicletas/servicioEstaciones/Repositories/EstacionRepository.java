package bicicletas.servicioEstaciones.Repositories;

import bicicletas.servicioEstaciones.Entities.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion,Long> {
}
