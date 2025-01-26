package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class insetaProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opcion = request.getParameter("opcion");
        String boton = request.getParameter("buton");
        String boton2 = request.getParameter("buton2");
        Conexion miConexion = new Conexion();

        try (PrintWriter out = response.getWriter()) {
            if (opcion.equalsIgnoreCase("consola")) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Inserta Consolas</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Inserta Consolas</h1>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Nombre:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"nombre\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Cpu_potencia:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"cpu_potencia\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Gpu_potencia:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"gpu_potencia\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Compania:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"compania\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Precio:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"precio\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Unidades_disponibles:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"unidades_disponibles\"></td>");
                out.println("<td class=\"dato\"><input type=\"hidden\" name=\"opcion\" value=" + opcion + "></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"submit\" name=\"buton\" value=\"Enviar\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton.equalsIgnoreCase("Enviar")) {
                    String nombre = request.getParameter("nombre");
                    String cpuPon = request.getParameter("cpu_potencia");
                    String gpuPon = request.getParameter("gpu_potencia");
                    String compania = request.getParameter("compania");
                    String precio = request.getParameter("precio");
                    String unidades_disponibles = request.getParameter("unidades_disponibles");

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Inserta Consolas</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    if (miConexion.insertaConsolas(nombre, cpuPon, gpuPon, compania, precio, unidades_disponibles)) {
                        out.println("<p style=\"color: green;\">Producto Insertado Correctamente</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto no insertado</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a insertar un producto</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else if (opcion.equalsIgnoreCase("juego")) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Inserta Juegos</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Inserta Juegos</h1>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Nombre:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"nombre\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Consola:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"consola\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Compania_desarrolladora:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"compania_desarrolladora\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Genero:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"genero\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Puntuacion_metacritic:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"puntuacion_metacritic\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Precio:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"precio\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Unidades_disponibles:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"unidades_disponibles\"></td>");
                out.println("<td class=\"dato\"><input type=\"hidden\" name=\"opcion\" value=" + opcion + "></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"submit\" name=\"buton2\" value=\"Enviar\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton2.equalsIgnoreCase("Enviar")) {
                    String nombre = request.getParameter("nombre");
                    String consola = request.getParameter("consola");
                    String compania_desarrolladora = request.getParameter("compania_desarrolladora");
                    String genero = request.getParameter("genero");
                    String puntuacion_metacritic = request.getParameter("puntuacion_metacritic");
                    String precio = request.getParameter("precio");
                    String unidades_disponibles = request.getParameter("unidades_disponibles");

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Inserta Juegos</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Inserta Juegos</h1>");
                    if (miConexion.insertaJuegos(nombre, consola, compania_desarrolladora, genero, puntuacion_metacritic, precio, unidades_disponibles)) {
                        out.println("<p style=\"color: green;\">Producto Insertado Correctamente</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto no Insertado</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a insertar un producto</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
