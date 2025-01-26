package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CompruebaUseradm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("password");
            Conexion miConexion = new Conexion();
            if (miConexion.esLogin(usuario, pass) == true) {
                if (miConexion.comprueboAdmin(usuario, pass)) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Admins</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id=\"cabecera\">");
                    //<!-- Hacer boton en la cabecera donde podamos iniciar sesion -->
                    out.println("<h1>Tienda Juegos</h1>");
                    out.println("<h3>Sesion Iniciada Bienvenido " + usuario +  " tienes permisos de administrador</h3>");
                    out.println("</div>");
                    //<!-- Aqui en el cuerpo añadimos las funcionalidades para poder mostrar los productos que tenemos en tienda dependiendo de lo que elija el usuario -->
                    out.println("<div id=\"cuerpo\">");
                    out.println("<a href=\"insertar.jsp\">Insertar Productos</a>");
                    out.println("<br>");
                    out.println("<a href=\"delete.jsp\">Eliminar un Producto</a>");
                    out.println("<br>");
                    out.println("<a href=\"update.jsp\">Modificar un Producto</a>");
                    out.println("</div>");
                    //<!-- si hacemos login con administrador hacer que pueda ejecutar otro tipo de acciones en la aplicacion -->
                    //<!--Aqui tenemos que tener el objetivo principal de la pagina que es que te muestre todo sin nada, poder hacer login y saber si es admin o no, l
                    //dependiendo de la accion que quiera ejecutar el usuario le manda a un lado u otro, lo principal hacerlo con jsp y usar servlet para segundas ejecuciones-->
                    out.println("</body>");
                    out.println("</html>");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Usuarios</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id=\"cabecera\">");
                    //<!-- Hacer boton en la cabecera donde podamos iniciar sesion -->
                    out.println("<h1>Tienda Juegos</h1>");
                    out.println("<h3>Sesion Iniciada Bienvenido " + usuario +  "</h3>");
                    out.println("</div>");
                    //<!-- Aqui en el cuerpo añadimos las funcionalidades para poder mostrar los productos que tenemos en tienda dependiendo de lo que elija el usuario -->
                    out.println("<div id=\"cuerpo\">");
                    out.println("<a href=\"consultaConsola\">Consultar las Consolas</a>");
                    out.println("<br>");
                    out.println("<a href=\"consultaJuegos\">Consultar los Juegos</a>");
                    out.println("<br>");
                    out.println("<a href=\"catalogoConsolas.jsp\">Catalogo de juegos en las consolas</a>");
                    out.println("<br>");
                    out.println("<a href=\"consultaTodo\">Catalogo de todos los productos</a>");
                    out.println("</div>");
                    //<!-- si hacemos login con administrador hacer que pueda ejecutar otro tipo de acciones en la aplicacion -->
                    //<!--Aqui tenemos que tener el objetivo principal de la pagina que es que te muestre todo sin nada, poder hacer login y saber si es admin o no, l
                    //dependiendo de la accion que quiera ejecutar el usuario le manda a un lado u otro, lo principal hacerlo con jsp y usar servlet para segundas ejecuciones-->
                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
