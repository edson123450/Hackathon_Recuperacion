package HackathonRecu.Album.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAlbum;
    private String nombre;
    private Date fechaDeLanzamiento;
    @OneToMany(mappedBy = "album")
    private List<Cancion> canciones;
}
