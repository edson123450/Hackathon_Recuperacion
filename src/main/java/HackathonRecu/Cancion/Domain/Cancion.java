package HackathonRecu.Cancion.Domain;

import HackathonRecu.Album.Domain.Album;
import HackathonRecu.Artista.Domain.Artista;
import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import HackathonRecu.User.Domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSong;
    private String titulo;
    @ManyToOne
    private Artista artista;
    @ManyToOne
    private Album album;
    private int duracion;
    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<ListaDeReproduccion> listaDeReproducciones;
}
