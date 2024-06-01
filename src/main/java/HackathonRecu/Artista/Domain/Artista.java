package HackathonRecu.Artista.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idArtist;
    private String nombre;
    @OneToMany(mappedBy = "artista")
    private List<Cancion> canciones;
}
