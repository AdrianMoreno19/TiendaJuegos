<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estilos.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Usuario</h1>
        <form action="compruebaUseradm" method="post">
            <table>
                <tr>
                    <td class="etiqueta">Usuario:</td>
                    <td class="dato"><input type="text" name="usuario"></td>
                </tr>
                <tr>
                    <td class="etiqueta">Contraseña:</td>
                    <td class="dato"><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="buton" value="Enviar">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
