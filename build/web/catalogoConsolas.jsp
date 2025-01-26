<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Catalogo Consolas</h1>
        <form action="CatalogoConsolas" method="post">
            <table>
                <tr>
                    <td class="etiqueta">Consola:</td>
                    <td class="dato"><input type="text" name="consola"></td>
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
