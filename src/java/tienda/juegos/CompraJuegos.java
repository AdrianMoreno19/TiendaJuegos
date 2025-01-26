package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CompraJuegos", urlPatterns = {"/compraJuegos"})
public class CompraJuegos extends HttpServlet {

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
            out.println("<title>Servlet CompraJuegos</title>");
            out.println("</head>");
            out.println("<body>");
            if (miConexion.comprarJuego(id, opcion1) == true) {
                out.println("<h1>Venta de juegos</h1>");
                out.println("<p>Juego comprado correctamente</p>");
            } else {
                out.println("<h1>Venta de juegos</h1>");
                out.println("<p>Juego no Comprado</p>");
            }
            out.println("<br>");
            out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
            out.println("<br><br>");
            out.println("<a href=\"consultaJuegos\">Volver a comprar un juego</a>");
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
