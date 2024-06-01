package HackathonRecu.User.Domain;

import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import HackathonRecu.ListaDeReproduccion.Infrastructure.ListaDeReproduccionRepository;
import HackathonRecu.User.Infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ListaDeReproduccionRepository listaDeReproduccionRepository;

    /*public User findByEmail(String username, String role) {
        User user;
        if (role.equals("ROLE_DRIVER"))
            user = driverRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        else
            user = passengerRepository.findByEmail(username).orElseThrow(() -> new UnauthorizeOperationException("User nottt found"));

        return user;
    }*/

    @Bean(name = "UserDetailsService")
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository
                    .findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return (UserDetails) user;
        };
    }




    public List<ListaDeReproduccion> get_user_playlists(Long userId){
        User user=userRepository.findById(userId).get();
        return user.getListaDeReproducciones();
    }

    public ListaDeReproduccion post_user_playlist(Long userId,ListaDeReproduccion playlist){
        User user=userRepository.findById(userId).get();
        listaDeReproduccionRepository.save(playlist);
        user.getListaDeReproducciones().add(playlist);
        userRepository.save(user);
        return playlist;
    }
}
