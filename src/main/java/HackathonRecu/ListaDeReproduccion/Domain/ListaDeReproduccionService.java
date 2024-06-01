package HackathonRecu.ListaDeReproduccion.Domain;

import HackathonRecu.Cancion.Domain.Cancion;
import HackathonRecu.Cancion.Infrastructure.CancionRepository;
import HackathonRecu.ListaDeReproduccion.Infrastructure.ListaDeReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeReproduccionService {
    @Autowired
    ListaDeReproduccionRepository listaDeReproduccionRepository;
    @Autowired
    CancionRepository cancionRepository;


    public ListaDeReproduccion getPlaylist(Long playlistId){
        ListaDeReproduccion playlist=listaDeReproduccionRepository.findById(playlistId).get();
        return playlist;
    }


    public ListaDeReproduccion putPlaylist(Long playlistId,ListaDeReproduccion playlist){
        ListaDeReproduccion playlistToUpdate=listaDeReproduccionRepository.findById(playlistId).get();
        playlistToUpdate.setUser(playlist.getUser());
        playlistToUpdate.setNombre(playlist.getNombre());
        playlistToUpdate.setFechaDeCreacion(playlist.getFechaDeCreacion());
        return listaDeReproduccionRepository.save(playlistToUpdate);
    }

    public void deletePlaylist(Long playlistId){
        ListaDeReproduccion playlist=listaDeReproduccionRepository.findById(playlistId).get();
        listaDeReproduccionRepository.delete(playlist);
    }


    public List<Cancion> getPlaylistCanciones(Long playlistId){
        ListaDeReproduccion playlit=listaDeReproduccionRepository.findById(playlistId).get();
        return playlit.getCanciones();
    }

    public ListaDeReproduccion postPlaylistCancion(Long playlistId,Cancion cancion){
        ListaDeReproduccion playlist=listaDeReproduccionRepository.findById(playlistId).get();
        playlist.getCanciones().add(cancion);
        ListaDeReproduccion playlistNew=listaDeReproduccionRepository.save(playlist);
        return playlistNew;
    }

    public void deletePlaylistSong(Long playlistId,Long cancionId){
        ListaDeReproduccion playlist=listaDeReproduccionRepository.findById(playlistId).get();
        Cancion cancion=cancionRepository.findById(cancionId).get();
        playlist.getCanciones().remove(cancion);
        cancion.getListaDeReproducciones().remove(playlist);
        cancionRepository.save(cancion);
        listaDeReproduccionRepository.save(playlist);
    }


}
