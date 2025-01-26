package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProductos extends HttpServlet {

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
                out.println("<title>Update Consolas</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Update Consolas</h1>");
                out.println(miConexion.mostrarConsolas2());
                out.println("<br>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<h3>Quieres actualizar una consola?</h3>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Nombre:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"nombre\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">CPU Potencia:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"cpu_potencia\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">GPU Potencia:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"gpu_potencia\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Compañía:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"compania\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Precio:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"precio\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Unidades Disponibles:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"unidades_disponibles\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"hidden\" name=\"opcion\" value=" + opcion + ">");
                out.println("<input type=\"submit\" name=\"buton\" value=\"Enviar\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton.equalsIgnoreCase("Enviar")) {
                    String nombre = request.getParameter("nombre");
                    String cpuPo = request.getParameter("cpu_potencia");
                    String gpuPo = request.getParameter("gpu_potencia");
                    String compania = request.getParameter("compania");
                    String precio = request.getParameter("precio");
                    String unidades_disponibles = request.getParameter("unidades_disponibles");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Consolas 2</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    if (miConexion.updateConsolas(nombre, cpuPo, gpuPo, compania, precio, unidades_disponibles)) {
                        out.println("<p style=\"color: green;\">Producto Actualizado Correctamente</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto no actualizado Correctamente</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a Updatear un producto</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else if (opcion.equalsIgnoreCase("juego")) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Update Juegos</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Update Juegos</h1>");
                out.println(miConexion.mostrarJuegos2());
                out.println("<br>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<h3>Quieres actualizar un juego?</h3>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">ID:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"id\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Nombre:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"nombre\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Consola:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"consola\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Compañía Desarrolladora:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"compania_desarrolladora\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Género:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"genero\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Puntuación Metacritic:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"puntuacion_metacritic\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Precio:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"precio\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">Unidades Disponibles:</td>");
                out.println("<td class=\"dato\"><input type=\"number\" name=\"unidades_disponibles\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"hidden\" name=\"opcion\" value=" + opcion + ">");
                out.println("<input type=\"submit\" name=\"buton2\" value=\"Enviar\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton2.equalsIgnoreCase("Enviar")) {
                    String id = request.getParameter("id");
                    String nombre = request.getParameter("nombre");
                    String consola = request.getParameter("consola");
                    String compañi = request.getParameter("compania_desarrolladora");
                    String genero = request.getParameter("genero");
                    String puntuacion_metacritic = request.getParameter("puntuacion_metacritic");
                    String precio = request.getParameter("precio");
                    String unidades_disponibles = request.getParameter("unidades_disponibles");

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Juegos</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    if (miConexion.updateJuegos(id, nombre, consola, compañi, genero, puntuacion_metacritic, precio, unidades_disponibles)) {
                        out.println("<p style=\"color: green;\">Producto Actualizado</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto No Actualizado Correctamente</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a updatear un producto</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
