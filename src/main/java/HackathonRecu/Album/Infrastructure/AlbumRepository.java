package HackathonRecu.Album.Infrastructure;

import HackathonRecu.Album.Domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
}
