package HackathonRecu.ListaDeReproduccion.Application;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccion;
import HackathonRecu.ListaDeReproduccion.Domain.ListaDeReproduccionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class ListaDeReproduccionController {

    @Autowired
    ListaDeReproduccionService listaDeReproduccionService;

    @GetMapping("/{playlistId}")
    public ResponseEntity<ListaDeReproduccion> getPlaylist(@PathVariable Long playlistId){
        return ResponseEntity.ok(listaDeReproduccionService.getPlaylist(playlistId));
    }

    @PutMapping("/{playlistId}")
    public ResponseEntity<ListaDeReproduccion> PutPlaylist(@PathVariable Long playlistId,@RequestBody ListaDeReproduccion playlist){
        return ResponseEntity.ok(listaDeReproduccionService.putPlaylist(playlistId,playlist));
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long playlistId){
        listaDeReproduccionService.deletePlaylist(playlistId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{playlist_id}/songs")
    public ResponseEntity<List<Cancion>> get_canciones(@PathVariable Long playlist_id){
        return ResponseEntity.ok(listaDeReproduccionService.getPlaylistCanciones(playlist_id));
    }
    @PostMapping("/{playlist_id}/songs")
    public ResponseEntity<ListaDeReproduccion> postCancion(@PathVariable Long playlist_id,Cancion cancion){
        return new ResponseEntity<>(listaDeReproduccionService.postPlaylistCancion(playlist_id,cancion),HttpStatus.CREATED);
    }
    @DeleteMapping("/{playlist_id}/songs/{song_id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long playlist_id,@PathVariable Long song_id){
        listaDeReproduccionService.deletePlaylistSong(playlist_id,song_id);
        return ResponseEntity.noContent().build();
    }



}
