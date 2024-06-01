package HackathonRecu.ListaDeReproduccion.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.User.Domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class ListaDeReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPlaylist;
    private String nombre;
    @ManyToOne
    private User user;
    private Date fechaDeCreacion;
    @ManyToMany(mappedBy = "listaDeReproducciones")
    List<Cancion> canciones;
}
