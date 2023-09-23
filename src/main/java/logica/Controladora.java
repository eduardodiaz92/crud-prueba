package logica;
import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia ();
    
    // Metodos
    public void crearPelicula (Pelicula pelicula) {
        controlPersis.crearPelicula(pelicula);
    }
    
    public List<Pelicula> traerPeliculas() {
        return controlPersis.traerPeliculas();
    }

    public void borrarPelicula(int id_eliminar) {
        controlPersis.borrarPelicula(id_eliminar);
   }

    public Pelicula traerPelicula(int id_editar) {
       return controlPersis.traerPelicula(id_editar);
    }

    public void editarPelicula(Pelicula pelicula) {
        controlPersis.editarPelicula(pelicula);
    }

   
    
}
