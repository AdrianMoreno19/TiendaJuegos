<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Update Productos</h1>
        <form action="updateProductos" method="post">
            <table>
                <tr>
                    <td class="etiqueta">Producto Consola o Juego:</td>
                    <td class="dato"><input type="text" name="opcion"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="boton" value="enviar">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
