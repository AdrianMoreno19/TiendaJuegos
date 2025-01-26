package tienda.juegos;

import static java.lang.System.out;
import java.sql.*;

public class Conexion {

    private Connection miConexion;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendavideojuegos", "daw2", "1234");
        } catch (SQLException | ClassNotFoundException e) {
            out.println(e.getMessage());
        }
    }

    public boolean esLogin(String user, String pass) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("select * from Usuarios where username = ? and password = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            miStatement.setString(1, user);
            miStatement.setString(2, pass);
            ResultSet miResult = miStatement.executeQuery();
            if (miResult.absolute(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean comprueboAdmin(String user, String pass) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("select * from Usuarios where username = ? and password = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            miStatement.setString(1, user);
            miStatement.setString(2, pass);
            ResultSet miResult = miStatement.executeQuery();
            if (miResult.absolute(1)) {
                Boolean admin = miResult.getBoolean("esAdmin");
                if (admin == true) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public String mostrarConsolas() {
        String html = "";
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("SELECT * FROM consolas");
            ResultSet miResult = miStatement.executeQuery();

            html += "<table border='1'>";
            html += "<tr><th>ID</th><th>Nombre</th><th>cpu_potencia</th><th>gpu_potencia</th><th>compania</th><th>precio</th><th>unidades_disponibles</th>";

            while (miResult.next()) {
                String id = miResult.getString("id");
                String nombre = miResult.getString("nombre");
                String cpuPo = miResult.getString("cpu_potencia");
                String gpuPo = miResult.getString("gpu_potencia");
                String compania = miResult.getString("compania");
                String precio = miResult.getString("precio");
                String unidadesDis = miResult.getString("unidades_disponibles");
                html += "<tr>";
                html += "<td>" + id + "</td>";
                html += "<td>" + nombre + "</td>";
                html += "<td>" + cpuPo + "</td>";
                html += "<td>" + gpuPo + "</td>";
                html += "<td>" + compania + "</td>";
                html += "<td>" + precio + "</td>";
                html += "<td>" + unidadesDis + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            
            html += "<br>";
            html += "<h1>Deseas Comprar una Consola</h1>";
            html += "<form action=\"compraConsola\" method=\"post\">";
            html += "<table>";
            html += "<tr>";
            html += "<td class=\"etiqueta\">ID:</td>";
            html += "<td class=\"dato\"><input type=\"text\" name=\"id\"></td>";
            html += "</tr>";
            html += "</table>";
            html += "<input type=\"submit\" name=\"buton\" value=\"Si\">";
            html += "<input type=\"submit\" name=\"buton\" value=\"No\" style='margin-left: 10px'>";
            html += "</form>";
            html += "<br>";
            
        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }
        return html;
    }
    
    public String mostrarConsolas2() {
        String html = "";
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("SELECT * FROM consolas");
            ResultSet miResult = miStatement.executeQuery();

            html += "<table border='1'>";
            html += "<tr><th>ID</th><th>Nombre</th><th>cpu_potencia</th><th>gpu_potencia</th><th>compania</th><th>precio</th><th>unidades_disponibles</th>";

            while (miResult.next()) {
                String id = miResult.getString("id");
                String nombre = miResult.getString("nombre");
                String cpuPo = miResult.getString("cpu_potencia");
                String gpuPo = miResult.getString("gpu_potencia");
                String compania = miResult.getString("compania");
                String precio = miResult.getString("precio");
                String unidadesDis = miResult.getString("unidades_disponibles");
                html += "<tr>";
                html += "<td>" + id + "</td>";
                html += "<td>" + nombre + "</td>";
                html += "<td>" + cpuPo + "</td>";
                html += "<td>" + gpuPo + "</td>";
                html += "<td>" + compania + "</td>";
                html += "<td>" + precio + "</td>";
                html += "<td>" + unidadesDis + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            
        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }
        return html;
    }

    public String mostrarJuegos() {
        String html = "";
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("SELECT * FROM juegos");
            ResultSet miResult = miStatement.executeQuery();

            html += "<table border='1'>";
            html += "<tr><th>ID</th><th>Nombre</th><th>Consola</th><th>compañia_desarrolladora</th><th>genero</th><th>puntuacion_metacritic</th><th>precio</th><th>unidades_disponibles</th>";

            while (miResult.next()) {
                String id = miResult.getString("id");
                String nombre = miResult.getString("nombre");
                String consola = miResult.getString("consola");
                String companiaDesarr = miResult.getString("compania_desarrolladora");
                String genero = miResult.getString("genero");
                String puntuacionMeta = miResult.getString("puntuacion_metacritic");
                String precio = miResult.getString("precio");
                String unidadesDis = miResult.getString("unidades_disponibles");
                
                html += "<tr>";
                html += "<td>" + id + "</td>";
                html += "<td>" + nombre + "</td>";
                html += "<td>" + consola + "</td>";
                html += "<td>" + companiaDesarr + "</td>";
                html += "<td>" + genero + "</td>";
                html += "<td>" + puntuacionMeta + "</td>";
                html += "<td>" + precio + "</td>";
                html += "<td>" + unidadesDis + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            
            html += "<br>";
            html += "<h1>Deseas Comprar un juego</h1>";
            html += "<form action=\"compraJuegos\" method=\"post\">";
            html += "<table>";
            html += "<tr>";
            html += "<td class=\"etiqueta\">ID:</td>";
            html += "<td class=\"dato\"><input type=\"text\" name=\"id\"></td>";
            html += "</tr>";
            html += "</table>";
            html += "<input type=\"submit\" name=\"buton\" value=\"Si\">";
            html += "<input type=\"submit\" name=\"buton\" value=\"No\" style='margin-left: 10px'>";
            html += "</form>";
            html += "<br>";
            
        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }
        return html;
    }
    
    public String mostrarJuegos2() {
        String html = "";
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("SELECT * FROM juegos");
            ResultSet miResult = miStatement.executeQuery();

            html += "<table border='1'>";
            html += "<tr><th>ID</th><th>Nombre</th><th>Consola</th><th>compañia_desarrolladora</th><th>genero</th><th>puntuacion_metacritic</th><th>precio</th><th>unidades_disponibles</th>";

            while (miResult.next()) {
                String id = miResult.getString("id");
                String nombre = miResult.getString("nombre");
                String consola = miResult.getString("consola");
                String companiaDesarr = miResult.getString("compania_desarrolladora");
                String genero = miResult.getString("genero");
                String puntuacionMeta = miResult.getString("puntuacion_metacritic");
                String precio = miResult.getString("precio");
                String unidadesDis = miResult.getString("unidades_disponibles");
                
                html += "<tr>";
                html += "<td>" + id + "</td>";
                html += "<td>" + nombre + "</td>";
                html += "<td>" + consola + "</td>";
                html += "<td>" + companiaDesarr + "</td>";
                html += "<td>" + genero + "</td>";
                html += "<td>" + puntuacionMeta + "</td>";
                html += "<td>" + precio + "</td>";
                html += "<td>" + unidadesDis + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            
        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }
        return html;
    }
    
    public String catalogoConsola(String consola) {
        String html = "";
        String consulta = "SELECT id, nombre, consola, compania_desarrolladora, genero, puntuacion_metacritic, "
                + "precio, unidades_disponibles from juegos where consola = ?";
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement(consulta);
            miStatement.setString(1, consola);
            ResultSet miResult = miStatement.executeQuery();

            html += "<h1>La consola es: " + consola + "</h1>";
            html += "<table border='1'>";
            html += "<tr></th><th>ID</th><th>Nombre</th><th>Consola</th><th>compañia_desarrolladora</th><th>genero</th><th>puntuacion_metacritic</th><th>precio</th><th>unidades_disponibles</th>";

            while (miResult.next()) {
                String id = miResult.getString("id");
                String nombre = miResult.getString("nombre");
                String companiaDesarr = miResult.getString("compania_desarrolladora");
                String genero = miResult.getString("genero");
                String puntuacionMeta = miResult.getString("puntuacion_metacritic");
                String precio = miResult.getString("precio");
                String unidadesDis = miResult.getString("unidades_disponibles");
                html += "<tr>";
                html += "<td>" + id + "</td>";
                html += "<td>" + nombre + "</td>";
                html += "<td>" + consola + "</td>";
                html += "<td>" + companiaDesarr + "</td>";
                html += "<td>" + genero + "</td>";
                html += "<td>" + puntuacionMeta + "</td>";
                html += "<td>" + precio + "</td>";
                html += "<td>" + unidadesDis + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            
            html += "<br>";
            html += "<h1>Deseas Comprar un juego</h1>";
            html += "<form action=\"compraJuegos\" method=\"post\">";
            html += "<table>";
            html += "<tr>";
            html += "<td class=\"etiqueta\">ID:</td>";
            html += "<td class=\"dato\"><input type=\"text\" name=\"id\"></td>";
            html += "</tr>";
            html += "</table>";
            html += "<input type=\"submit\" name=\"buton\" value=\"Si\">";
            html += "<input type=\"submit\" name=\"buton\" value=\"No\" style='margin-left: 10px'>";
            html += "</form>";
        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }

        return html;
    }

    public String mostrarTodo() {
        String html = "";
        String consultaJuegos = "SELECT * FROM juegos";
        String consultaConsolas = "SELECT * FROM consolas";

        try {
            PreparedStatement miStatementJuegos = this.miConexion.prepareStatement(consultaJuegos);
            ResultSet miResultJuegos = miStatementJuegos.executeQuery();

            PreparedStatement miStatementConsolas = this.miConexion.prepareStatement(consultaConsolas);
            ResultSet miResultConsolas = miStatementConsolas.executeQuery();

            html += "<table border='1'>";
            html += "<tr><th>Nombre Juego</th><th>Consola</th><th>Precio Juego</th><th>Unidades Juego</th><th>Nombre Consola</th><th>Precio Consola</th><th>Unidades Consola</th></tr>";

            while (miResultJuegos.next()) {
                String nombreJu = miResultJuegos.getString("nombre");
                String consola = miResultJuegos.getString("consola");
                String precioJu = miResultJuegos.getString("precio");
                String unidadesDisJu = miResultJuegos.getString("unidades_disponibles");

                html += "<tr>";
                html += "<td>" + nombreJu + "</td>";
                html += "<td>" + consola + "</td>";
                html += "<td>" + precioJu + "</td>";
                html += "<td>" + unidadesDisJu + "</td>";

                if (miResultConsolas.next()) {
                    String nombreCo = miResultConsolas.getString("nombre");
                    String precioCo = miResultConsolas.getString("precio");
                    String unidadesDisCo = miResultConsolas.getString("unidades_disponibles");

                    html += "<td>" + nombreCo + "</td>";
                    html += "<td>" + precioCo + "</td>";
                    html += "<td>" + unidadesDisCo + "</td>";
                } else {

                    html += "<td>-</td><td>-</td><td>-</td>";
                }
                html += "</tr>";
            }
            html += "</table>";
            // Cerrar recursos
            miResultJuegos.close();
            miResultConsolas.close();
            miStatementJuegos.close();
            miStatementConsolas.close();

        } catch (SQLException e) {
            html = "<p>Error: " + e.getMessage() + "</p>";
        }

        return html;
    }

    public boolean insertaConsolas(String nombre, String cpu_potencia, String gpu_potencia, String compania, String precio, String unidades_disponibles) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("insert into consolas (nombre, cpu_potencia, gpu_potencia, compania, precio, unidades_disponibles) values (?, ?, ?, ?, ?, ?)");
            if (nombre.equals("") || cpu_potencia.equals("") || gpu_potencia.equals("") || compania.equals("") || precio.equals("") || unidades_disponibles.equals("")) {
                return false;
            } else {
                miStatement.setString(1, nombre);
                miStatement.setString(2, cpu_potencia);
                miStatement.setString(3, gpu_potencia);
                miStatement.setString(4, compania);
                miStatement.setString(5, precio);
                miStatement.setString(6, unidades_disponibles);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean insertaJuegos(String nombre, String consola, String compania_desarrolladora, String genero, String puntuacion_metacritic, String precio, String unidades_disponibles) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("insert into juegos (nombre, consola, compania_desarrolladora, genero, puntuacion_metacritic, precio, unidades_disponibles) values (?,?,?,?,?,?,?)");
            if (nombre.equals("") || consola.equals("") || compania_desarrolladora.equals("") || genero.equals("") || puntuacion_metacritic.equals("") || precio.equals("") || unidades_disponibles.equals("")) {
                return false;
            } else {
                miStatement.setString(1, nombre);
                miStatement.setString(2, consola);
                miStatement.setString(3, compania_desarrolladora);
                miStatement.setString(4, genero);
                miStatement.setString(5, puntuacion_metacritic);
                miStatement.setString(6, precio);
                miStatement.setString(7, unidades_disponibles);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteConsolas(String id) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("delete from juegosconsolas where consola_id=?");
            if (id.equals("")) {
                return false;
            } else {
                miStatement.setString(1, id);
                miStatement.executeUpdate();
                miStatement = this.miConexion.prepareStatement("delete from consolas where id=?");
                miStatement.setString(1, id);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteJuegos(String id) {
        try {
            PreparedStatement miStatement = this.miConexion.prepareStatement("delete from juegosconsolas where juego_id = ?");
            if (id.equals("")) {
                return false;
            } else {
                miStatement.setString(1, id);
                miStatement.executeUpdate();
                miStatement = this.miConexion.prepareStatement("delete from juegos where id=?");
                miStatement.setString(1, id);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateConsolas(String nombre, String cpu_potencia, String gpu_potencia, String compania, String precio, String unidades_disponibles) {
        try {
            if (nombre.equals("") || cpu_potencia.equals("") || gpu_potencia.equals("") || compania.equals("") || precio.equals("") || unidades_disponibles.equals("")) {
                return false;
            } else {
                String sql = "UPDATE consolas SET cpu_potencia = ?, gpu_potencia = ?, compania = ?, precio = ?, unidades_disponibles = ? WHERE nombre = ?";
                PreparedStatement miStatement = this.miConexion.prepareStatement(sql);
                miStatement.setString(1, cpu_potencia);
                miStatement.setString(2, gpu_potencia);
                miStatement.setString(3, compania);
                miStatement.setString(4, precio);
                miStatement.setString(5, unidades_disponibles);
                miStatement.setString(6, nombre);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateJuegos(String id, String nombre, String consola,  String compania_desarrolladora, String genero, String puntuacion_metacritic, String precio, String unidades_disponibles) {
        try {
            if (id.equals("") || nombre.equals("") || consola.equals("") || compania_desarrolladora.equals("") || genero.equals("") || puntuacion_metacritic.equals("") || precio.equals("") || unidades_disponibles.equals("")) {
                return false;
            } else {
                String sql = "UPDATE juegos SET  nombre = ?, consola = ?, compania_desarrolladora = ?, genero = ?, puntuacion_metacritic = ?, precio = ?, unidades_disponibles = ? WHERE id = ?";
                PreparedStatement miStatement = this.miConexion.prepareStatement(sql);
                miStatement.setString(1, nombre);
                miStatement.setString(2, consola);
                miStatement.setString(3, compania_desarrolladora);
                miStatement.setString(4, genero);
                miStatement.setString(5, puntuacion_metacritic);
                miStatement.setString(6, precio);
                miStatement.setString(7, unidades_disponibles);
                miStatement.setString(8, id);
                miStatement.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }

    public boolean comprarJuego(String id, String opcion) {
        try {
            String sql = "select id from juegos where id = " + id;
            PreparedStatement miStatement = this.miConexion.prepareStatement(sql);
            ResultSet miResultSet = miStatement.executeQuery();
            while (miResultSet.next()) {
                if (opcion.equalsIgnoreCase("si")) {
                    String consulta = "update juegos set unidades_disponibles = unidades_disponibles-1 where id = " + id;
                    PreparedStatement miStatement2 = this.miConexion.prepareStatement(consulta);
                    miStatement2.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean comprarConsola(String id, String opcion) {
        try {
            String sql = "select id from consolas where id = " + id;
            PreparedStatement miStatement = this.miConexion.prepareStatement(sql);
            ResultSet miResultSet = miStatement.executeQuery();
            while (miResultSet.next()) {
                if (opcion.equalsIgnoreCase("si")) {
                    String consulta = "update consolas set unidades_disponibles = unidades_disponibles-1 where id = " + id;
                    PreparedStatement miStatement2 = this.miConexion.prepareStatement(consulta);
                    miStatement2.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return false;
    }
}
