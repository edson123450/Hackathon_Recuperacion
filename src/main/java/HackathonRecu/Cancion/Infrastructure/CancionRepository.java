package HackathonRecu.Cancion.Infrastructure;

import HackathonRecu.Cancion.Domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion,Long> {
}
