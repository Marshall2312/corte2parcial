<%-- 
    Document   : ListarClientes
    Created on : 24/04/2025, 09:28:25 PM
    Author     : LUIS POLO GARCIA
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.veterinaria.persistencia.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Clientes</title>
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
    <h1>Listado de Clientes</h1>

    <%-- Mostrar cantidad de clientes recibidos para depuración --%>
    <p>Total de clientes: ${not empty clientes ? clientes.size() : 0}</p>

    <%-- Verificar si hay clientes y mostrarlos --%>
    <c:choose>
        <c:when test="${clientes != null && not empty clientes}">
            <table>
                <thead>
                    <tr>
                        <th>ID Cliente</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.idCliente}</td>
                            <td>${cliente.nombre}</td>
                            <td>${cliente.apellido}</td>
                            <td>${cliente.direccion}</td>
                            <td>${cliente.telefono}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="mensaje">No hay clientes registrados.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>

