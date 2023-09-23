
package persistencia;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Pelicula;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    PeliculaJpaController peliculaJpa = new PeliculaJpaController();
    
    // Operacion CREATE
    public void crearPelicula(Pelicula pelicula){
        peliculaJpa.create(pelicula);
    }
    
    // Operacion READ
    public List<Pelicula> traerPeliculas() {
        // Trae todos los usuarios que esten cargados en ese momento
        return peliculaJpa.findPeliculaEntities();
    }

    public void borrarPelicula(int id_eliminar) {
        try {
            peliculaJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pelicula traerPelicula(int id_editar) {
        return peliculaJpa.findPelicula(id_editar);
    }

    public void editarPelicula(Pelicula pelicula) {
        try {
            peliculaJpa.edit(pelicula);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
