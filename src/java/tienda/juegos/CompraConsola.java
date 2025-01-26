package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CompraConsola extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion1 = request.getParameter("buton");
        String id = request.getParameter("id");
        Conexion miConexion = new Conexion();
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CompraConsolas</title>");
            out.println("</head>");
            out.println("<body>");
            if (miConexion.comprarConsola(id, opcion1) == true) {
                out.println("<h1>Venta de Consolas</h1>");
                out.println("<p>Consola comprada correctamente</p>");
            } else {
                out.println("<h1>Venta de Consolas</h1>");
                out.println("<p>Consola no Comprada</p>");
            }
            out.println("<br>");
            out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
            out.println("<br><br>");
            out.println("<a href=\"consultaConsola\">Volver a comprar una Consola</a>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
