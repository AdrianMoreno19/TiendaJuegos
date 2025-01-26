package tienda.juegos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConsultaTodo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion miConexion = new Conexion();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Todo</title>");
            out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Todo</h1>");
            out.println(miConexion.mostrarTodo());
            out.println("<br>");
            out.println("<br>");
            out.println("<button onclick=\"location.href='index.html'\">Pagina Principal</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
