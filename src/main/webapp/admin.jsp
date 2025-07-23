<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modo Administrador</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
        }

        .container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 100%;
            max-width: 800px;
        }

        th, td {
            padding: 10px 15px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        a, button {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        a:hover, button:hover {
            background-color: #0056b3;
        }

        form {
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Reservas registradas</h2>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Duración</th>
            <th>Cancha</th>
            <th>Método de Pago</th>
            <th>Acciones</th>
        </tr>
        <%
            try {
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:reservas.db");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM reservas");
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("nombre") %></td>
            <td><%= rs.getString("fecha") %></td>
            <td><%= rs.getString("hora") %></td>
            <td><%= rs.getInt("duracion") %> h</td>
            <td><%= rs.getString("cancha") %></td>
            <td><%= rs.getString("pago") %></td>
            <td>
                <form method="post" action="eliminar">
                    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                    <button type="submit">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='7'>Error: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>
    <a href="index.jsp">Volver al inicio</a>
</div>
</body>
</html>