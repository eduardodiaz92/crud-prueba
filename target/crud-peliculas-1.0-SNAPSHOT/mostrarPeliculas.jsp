<%@page import="java.util.List"%>
<%@page import="logica.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de peliculas registradas</h1>        
        <%
            List<Pelicula> listaPeliculas = (List) request.getSession().getAttribute("listaPeliculas");
            int cont = 1;
            for (Pelicula pelicula : listaPeliculas) {
        %>
        <p><b>Pelicula # <%=cont%></b></p>
        <p>Id: <%=pelicula.getId()%></p>        
        <p>Nombre: <%=pelicula.getNombre()%></p>
        <p>Categoria: <%=pelicula.getCategoria()%></p>
        <p>Horario: <%=pelicula.getHorario()%></p>
        <p>Asientos disponibles: <%=pelicula.getAsientos()%></p>
        <p>--------------------------</p>
        <% cont = cont + 1; %>
        <% }%>
    </body>
</html>
