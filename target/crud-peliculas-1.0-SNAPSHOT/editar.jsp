<%@page import="logica.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pelicula</title>
    </head>
    <body>
        <% Pelicula pelicula = (Pelicula) request.getSession().getAttribute("peliculaEditar"); %>
        <h1>Datos del cliente</h1>
        <form action="SvEditar" method="POST">
            
            <p><label>Nombre: </label ><input type="text" name="nombre" value="<%= pelicula.getNombre()%>"></p>
            <p><label>Categoria: </label><input type="text" name="categoria" value="<%= pelicula.getCategoria()%>"></p>
            <p><label>Horario: </label><input type="text" name="horario" value="<%= pelicula.getHorario()%>"></p>
            <p><label>Asientos: </label><input type="number" name="asientos" value="<%= pelicula.getAsientos()%>"></p>
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
