package HackathonRecu.User.Application;

import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import HackathonRecu.User.Domain.UserService;
import HackathonRecu.User.Events.ConfirmationEmailEvent;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/{userId}/playlists")
    public ResponseEntity<List<ListaDeReproduccion>> get_user_playlists(@PathVariable Long userId){
        return ResponseEntity.ok(userService.get_user_playlists(userId));
    }

    @PostMapping("/{userId}/playlists")
    public ResponseEntity<ListaDeReproduccion> post_user_playlist(@PathVariable Long userId,@RequestBody ListaDeReproduccion playlist){
        applicationEventPublisher.publishEvent(new
                ConfirmationEmailEvent(playlist.getUser().getEmail()));
        return new ResponseEntity<>(userService.post_user_playlist(userId,playlist), HttpStatus.CREATED);
    }
}
