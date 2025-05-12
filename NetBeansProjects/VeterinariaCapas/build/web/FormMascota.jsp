<%-- 
    Document   : FormMascota
    Created on : 24/04/2025, 09:28:13 PM
    Author     : LUIS POLO GARCIA
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Mascotas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            color: #333;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
           ;
            border: 2px solid #4CAF50;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            width: 100%;
        }

        h1 {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            margin: -20px -20px 20px -20px;
            border-radius: 10px 10px 0 0;
            text-align: center;
        }

        .formulario {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .formulario label, .formulario input {
            width: 48%;
            margin-bottom: 10px;
        }

        .formulario button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        .formulario button:hover {
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
        <h1>Gestión de Mascotas</h1>

        <!-- Formulario para Registrar Mascota -->
        <form class="formulario" action="MascotaControl" method="POST">
            <input type="hidden" name="accion" value="registrar">
            <label>Nombre:</label>
            <input type="text" name="nombre" required>
            <label>Raza:</label>
            <input type="text" name="raza" required>
            <label>Edad:</label>
            <input type="number" name="edad" required>
            <label>ID Cliente:</label>
            <input type="number" name="idCliente" required>
            <button type="submit">Registrar</button>
        </form>

        <!-- Formulario para Actualizar Mascota -->
        <form class="formulario" action="MascotaControl" method="POST">
            <input type="hidden" name="accion" value="actualizar">
            <label>ID Mascota:</label>
            <input type="number" name="idMascota" required>
            <label>Nombre:</label>
            <input type="text" name="nombre" required>
            <label>Raza:</label>
            <input type="text" name="raza" required>
            <label>Edad:</label>
            <input type="number" name="edad" required>
            <label>ID Cliente:</label>
            <input type="number" name="idCliente" required>
            <button type="submit">Actualizar</button>
        </form>

        <!-- Formulario para Eliminar Mascota -->
        <form class="formulario" action="MascotaControl" method="POST">
            <input type="hidden" name="accion" value="eliminar">
            <label>ID Mascota:</label>
            <input type="number" name="idMascota" required>
            <button type="submit">Eliminar</button>
        </form>

        <!-- Botón para ir a index.html -->
        <button class="back-button" onclick="window.location.href='index.html'">Volver a Inicio</button>