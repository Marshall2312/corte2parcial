/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veterinaria.persistencia;

/**
 *
 * @author LUIS POLO GARCIA
 */

import com.veterinaria.accesodatos.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaRepositorio {
    // Registrar una mascota
    public boolean registrar(Mascota mascota) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "INSERT INTO mascota (nombre, raza, edad, id_cliente) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, mascota.getNombre());
        statement.setString(2, mascota.getRaza());
        statement.setInt(3, mascota.getEdad());
        statement.setInt(4, mascota.getIdCliente());

        boolean resultado = statement.executeUpdate() > 0;
        ConexionBD.cerrarConexion(conexion);
        return resultado;
    }

    // Listar todas las mascotas
public List<Mascota> listar() throws SQLException {
    Connection conexion = ConexionBD.conectar();
    String sql = "SELECT * FROM mascota"; // Recupera todos los registros de la tabla mascota
    PreparedStatement statement = conexion.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();

    List<Mascota> mascotas = new ArrayList<>();
    while (resultSet.next()) {
        Mascota mascota = new Mascota(
            resultSet.getInt("id_mascota"),
            resultSet.getString("nombre"),
            resultSet.getString("raza"),
            resultSet.getInt("edad"),
            resultSet.getInt("id_cliente")
        );
        mascotas.add(mascota);
    }
    System.out.println("Mascotas recuperadas: " + mascotas.size()); // Depuración
    ConexionBD.cerrarConexion(conexion);
    return mascotas;
}

    // Actualizar una mascota existente
    public boolean actualizar(Mascota mascota) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "UPDATE mascota SET nombre = ?, raza = ?, edad = ?, id_cliente = ? WHERE id_mascota = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, mascota.getNombre());
        statement.setString(2, mascota.getRaza());
        statement.setInt(3, mascota.getEdad());
        statement.setInt(4, mascota.getIdCliente());
        statement.setInt(5, mascota.getIdMascota());

        boolean resultado = statement.executeUpdate() > 0;
        ConexionBD.cerrarConexion(conexion);
        return resultado;
    }

    // Eliminar una mascota por ID
    public boolean eliminar(int idMascota) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        String sql = "DELETE FROM mascota WHERE id_mascota = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, idMascota);

        boolean resultado = statement.executeUpdate() > 0;
        ConexionBD.cerrarConexion(conexion);
        return resultado;
    }
}


