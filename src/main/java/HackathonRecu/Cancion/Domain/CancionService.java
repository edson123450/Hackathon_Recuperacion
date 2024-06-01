package HackathonRecu.Cancion.Domain;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/canciones")
public class CancionService {
    @GetMapping
    public ResponseEntity<List<Cancion>> get_canciones(){
        return ResponseEntity.ok();
    }



    @PostMapping
    public ResponseEntity

    @PutMapping

    @DeleteMapping

}
