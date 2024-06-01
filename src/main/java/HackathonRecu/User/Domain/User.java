package HackathonRecu.User.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUser;
    private String nombre;
    private String email;
    private Date fechaDeRegistro;
    @ManyToMany(mappedBy = "users")
    private List<Cancion> canciones;
    @OneToMany(mappedBy = "user")
    private List<ListaDeReproduccion> listaDeReproducciones;

}
