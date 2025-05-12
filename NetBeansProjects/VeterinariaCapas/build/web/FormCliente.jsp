<%-- 
    Document   : FormCliente
    Created on : 24/04/2025, 09:27:59 PM
    Author     : LUIS POLO GARCIA
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Clientes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            border: 2px solid #4CAF50;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }
        h1 {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            margin: -20px -20px 20px -20px;
            border-radius: 10px 10px 0 0;
            text-align: center;
        }
        .form-section {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .form-section label, .form-section input {
            width: 48%;
            margin-bottom: 10px;
        }
        .form-section button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
        .form-section button:hover {
            background-color: #45a049;
        }
        .back-button {
            width: 100%;
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
        .back-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Gestión de Clientes</h1>
        <!-- Formulario para Registrar Cliente -->
        <form action="ClienteControl" method="POST" class="form-section">
            <input type="hidden" name="accion" value="registrar">
            <label>Nombre:</label>
            <input type="text" name="nombre" required>
            <label>Apellido:</label>
            <input type="text" name="apellido" required>
            <label>Dirección:</label>
            <input type="text" name="direccion" required>
            <label>Teléfono:</label>
            <input type="text" name="telefono" required>
            <button type="submit">Registrar</button>
        </form>

        <!-- Formulario para Actualizar Cliente -->
        <form action="ClienteControl" method="POST" class="form-section">
            <input type="hidden" name="accion" value="actualizar">
            <label>ID Cliente (Actualizar):</label>
            <input type="number" name="idCliente" required>
            <label>Nombre:</label>
            <input type="text" name="nombre" required>
            <label>Apellido:</label>
            <input type="text" name="apellido" required>
            <label>Dirección:</label>
            <input type="text" name="direccion" required>
            <label>Teléfono:</label>
            <input type="text" name="telefono" required>
            <button type="submit">Actualizar</button>
        </form>

        <!-- Formulario para Eliminar Cliente -->
        <form action="ClienteControl" method="POST" class="form-section">
            <input type="hidden" name="accion" value="eliminar">
            <label>ID Cliente (Eliminar):</label>
            <input type="number" name="idCliente" required>
            <button type="submit">Eliminar</button>
        </form>

        <!-- Botón para ir a index.html -->
        <button class="back-button" onclick="window.location.href='index.html'">Volver a Inicio</button>
    </div>
</body>
</html>




