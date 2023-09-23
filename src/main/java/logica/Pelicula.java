package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    
    private String nombre;
    private String categoria;
    private String horario;
    private int asientos;

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, String categoria, String horario, int asientos) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.horario = horario;
        this.asientos = asientos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

   

    

}
