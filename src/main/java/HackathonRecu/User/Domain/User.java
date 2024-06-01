package HackathonRecu.User.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUser;
    private String nombre;
    private String email;
    private String password;
    private Date fechaDeRegistro;
    @ManyToMany(mappedBy = "users")
    private List<Cancion> canciones;
    @OneToMany(mappedBy = "user")
    private List<ListaDeReproduccion> listaDeReproducciones;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna una lista de autoridades vacía o una autoridad predeterminada
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
