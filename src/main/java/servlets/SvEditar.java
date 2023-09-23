package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Pelicula;


@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_editar = Integer.parseInt(request.getParameter("id_peliculaEdit"));
        Pelicula pelicula = control.traerPelicula(id_editar);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("peliculaEditar", pelicula);
        response.sendRedirect("editar.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String horario = request.getParameter("horario");
        Integer asientos = Integer.valueOf( request.getParameter("asientos"));
        
        Pelicula pelicula = (Pelicula) request.getSession().getAttribute("peliculaEditar");
        
        pelicula.setNombre(nombre);
        pelicula.setCategoria(categoria);
        pelicula.setHorario(horario);
        pelicula.setAsientos(asientos);
                
        control.editarPelicula(pelicula); 
        response.sendRedirect("index.html");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
