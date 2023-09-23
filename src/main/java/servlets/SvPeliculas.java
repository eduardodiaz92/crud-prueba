package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import logica.Pelicula;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;

@WebServlet(name = "SvPeliculas", urlPatterns = {"/SvPeliculas"})
public class SvPeliculas extends HttpServlet {
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvPeliculas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvPeliculas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas = control.traerPeliculas();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPeliculas", listaPeliculas);

        response.sendRedirect("mostrarPeliculas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String horario = request.getParameter("horario");
        Integer asientos = Integer.valueOf(request.getParameter("asientos"));

        Pelicula pelicula = new Pelicula();
        
        pelicula.setNombre(nombre);
        pelicula.setCategoria(categoria);
        pelicula.setHorario(horario);
        pelicula.setAsientos(asientos);

        control.crearPelicula(pelicula);
        response.sendRedirect("index.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
