package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteProductos extends HttpServlet {

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
                out.println("<title>Elimina Consolas</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Elimina Consolas</h1>");
                out.println(miConexion.mostrarConsolas2());
                out.println("<br>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<h3>Quieres eliminar una consola?</h3>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">ID:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"id\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"submit\" name=\"buton\" value=\"Enviar\">");
                out.println("</td>");
                out.println("<td class=\"dato\"><input type=\"hidden\" name=\"opcion\" value=" + opcion + "></td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton.equalsIgnoreCase("Enviar")) {
                    String id = request.getParameter("id");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>delete Consolas</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    if (miConexion.deleteConsolas(id)) {
                        out.println("<p style=\"color: green;\">Producto Eliminado Correctamente</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto No Eliminado</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a eliminar un producto</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else if (opcion.equalsIgnoreCase("juego")) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Elimina Juegos</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Elimina Juegos</h1>");
                out.println(miConexion.mostrarJuegos2());
                out.println("<br>");
                out.println("<form action=\"?\" method=\"post\">");
                out.println("<table>");
                out.println("<h3>Quieres eliminar un juego?</h3>");
                out.println("<tr>");
                out.println("<td class=\"etiqueta\">ID:</td>");
                out.println("<td class=\"dato\"><input type=\"text\" name=\"id\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                out.println("<input type=\"submit\" name=\"buton2\" value=\"Enviar\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("<td class=\"dato\"><input type=\"hidden\" name=\"opcion\" value=" + opcion + "></td>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                if (boton2.equalsIgnoreCase("Enviar")) {
                    String id = request.getParameter("id");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>delete Juegos</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    if (miConexion.deleteJuegos(id)) {
                        out.println("<p style=\"color: green;\">Producto Eliminado Correctamente</p>");
                    } else {
                        out.println("<p style=\"color: red;\">Producto No Eliminado</p>");
                    }
                    out.println("<br>");
                    out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
                    out.println("<br><br>");
                    out.println("<a href=\"?\">Volver a eliminar un producto</a>");
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
