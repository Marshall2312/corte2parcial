<%-- 
    Document   : ListarMascotas
    Created on : 24/04/2025, 09:28:37 PM
    Author     : LUIS POLO GARCIA
--%>
<%-- 
    Document   : ListarMascotas
    Created on : 24/04/2025, 09:28:25 PM
    Author     : LUIS POLO GARCIA
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.veterinaria.persistencia.Mascota" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Mascotas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .mensaje {
            color: #ff0000;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Listado de Mascotas</h1>

    <%-- Mostrar cantidad de mascotas recibidas para depuración --%>
    <p>Total de mascotas: ${not empty mascotas ? mascotas.size() : 0}</p>

    <%-- Verificar si hay mascotas y mostrarlas --%>
    <c:choose>
        <c:when test="${mascotas != null && not empty mascotas}">
            <table>
                <thead>
                    <tr>
                        <th>ID Mascota</th>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Edad</th>
                        <th>ID Cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mascota" items="${mascotas}">
                        <tr>
                            <td>${mascota.idMascota}</td>
                            <td>${mascota.nombre}</td>
                            <td>${mascota.raza}</td>
                            <td>${mascota.edad}</td>
                            <td>${mascota.idCliente}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="mensaje">No hay mascotas registradas.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>

