package HackathonRecu.Artista.Infrastructure;

import HackathonRecu.Artista.Domain.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Long> {
}
