package HackathonRecu.Cancion.Application;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.Cancion.Domain.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @GetMapping
    public ResponseEntity<List<Cancion>> getCanciones(){
        return ResponseEntity.ok(cancionService.getCanciones());
    }
    @PostMapping
    public ResponseEntity<Cancion> post_cancion(@RequestBody Cancion cancion){
        return new ResponseEntity<>(cancionService.postCancion(cancion),HttpStatus.CREATED);
    }

    @PutMapping("/{cancionId}")
    public ResponseEntity<Cancion> putCancion(@PathVariable Long cancionId,@RequestBody Cancion cancion){
        return ResponseEntity.ok(cancionService.putCancion(cancionId,cancion));
    }

    @DeleteMapping("/{cancionId}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long cancionId){
        cancionService.deleteCancion(cancionId);
        return ResponseEntity.noContent().build();
    }

}
