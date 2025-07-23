<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reservar Cancha</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
        }

        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        input, select, button {
            margin: 10px 0;
            padding: 10px;
            width: 100%;
            max-width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        a {
            display: block;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Formulario de Reserva</h2>
    <form action="registrar" method="post">
        <input type="text" name="nombre" placeholder="Tu nombre" required><br>
        <input type="date" name="fecha" required><br>
        <input type="time" name="hora" required><br>
        <input type="number" name="duracion" placeholder="Duración (horas)" required><br>
        <input type="text" name="cancha" placeholder="Cancha (Ej. Fútbol)" required><br>
        <select name="pago" required>
            <option value="">Método de pago</option>
            <option value="Efectivo">Efectivo</option>
            <option value="Tarjeta">Tarjeta</option>
            <option value="Yape/Plin">Yape/Plin</option>
        </select><br>
        <button type="submit">Reservar</button>
    </form>
    <a href="index.jsp">⬅ Volver al inicio</a>
</div>
</body>
</html>