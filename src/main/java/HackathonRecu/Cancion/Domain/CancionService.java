package HackathonRecu.Cancion.Domain;

import HackathonRecu.Cancion.Infrastructure.CancionRepository;
import HackathonRecu.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getCanciones(){
        return cancionRepository.findAll();
    }
    public Cancion postCancion(Cancion cancion){
        return cancionRepository.save(cancion);
    }

    public Cancion putCancion(Long cancionId,Cancion cancion){
        Cancion cancionToUpdate=cancionRepository.findById(cancionId).orElseThrow(()->new NotFoundException("Cancion no encontrada"));
        cancionToUpdate.setTitulo(cancion.getTitulo());
        cancionToUpdate.setAlbum(cancion.getAlbum());
        cancionToUpdate.setArtista(cancion.getArtista());
        cancionToUpdate.setDuracion(cancion.getDuracion());
        return cancionRepository.save(cancionToUpdate);
    }

    public Cancion deleteCancion(Long cancionId){
        Cancion cancion=cancionRepository.findById(cancionId).orElseThrow(()->new NotFoundException("Cancion no encontrada"));
        cancionRepository.delete(cancion);
        return cancion;

    }
}
