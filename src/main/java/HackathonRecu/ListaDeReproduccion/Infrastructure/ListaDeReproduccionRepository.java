package HackathonRecu.ListaDeReproduccion.Infrastructure;

import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion,Long> {
}
