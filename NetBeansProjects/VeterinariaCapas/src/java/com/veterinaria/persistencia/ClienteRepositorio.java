package com.veterinaria.persistencia;

import com.veterinaria.accesodatos.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {

    // Registrar un cliente
    public boolean registrar(Cliente cliente) throws SQLException {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            System.out.println("[INFO] Conexión para registrar cliente: " + (conexion != null)); // Depuración

            String sql = "INSERT INTO cliente (nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?)";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getTelefono());

            boolean resultado = statement.executeUpdate() > 0; // Devuelve true si se registró correctamente
            System.out.println("[INFO] Cliente registrado: " + resultado); // Depuración
            return resultado;
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al registrar cliente: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Error al registrar cliente: " + e.getMessage());
        } finally {
            cerrarRecursos(statement, conexion);
        }
    }

    // Listar todos los clientes
    public List<Cliente> listar() throws SQLException {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conexion = ConexionBD.conectar();
            System.out.println("[INFO] Conexión para listar clientes: " + (conexion != null)); // Depuración

            String sql = "SELECT * FROM cliente";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("direccion"),
                    resultSet.getString("telefono")
                );
                clientes.add(cliente);
            }
            System.out.println("[INFO] Clientes recuperados desde la base de datos: " + clientes.size()); // Depuración
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al listar clientes: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Error al listar clientes: " + e.getMessage());
        } finally {
            cerrarRecursos(resultSet, statement, conexion);
        }
        return clientes;
    }

    // Actualizar un cliente existente
    public boolean actualizar(Cliente cliente) throws SQLException {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            System.out.println("[INFO] Conexión para actualizar cliente: " + (conexion != null)); // Depuración

            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id_cliente = ?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getTelefono());
            statement.setInt(5, cliente.getIdCliente());

            boolean resultado = statement.executeUpdate() > 0; // Devuelve true si se actualizó correctamente
            System.out.println("[INFO] Cliente actualizado: " + resultado); // Depuración
            return resultado;
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al actualizar cliente: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Error al actualizar cliente: " + e.getMessage());
        } finally {
            cerrarRecursos(statement, conexion);
        }
    }

    // Eliminar un cliente por ID
    public boolean eliminar(int idCliente) throws SQLException {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            System.out.println("[INFO] Conexión para eliminar cliente: " + (conexion != null)); // Depuración

            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, idCliente);

            boolean resultado = statement.executeUpdate() > 0; // Devuelve true si se eliminó correctamente
            System.out.println("[INFO] Cliente eliminado: " + resultado); // Depuración
            return resultado;
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al eliminar cliente: " + e.getMessage());
            e.printStackTrace();
            throw new SQLException("Error al eliminar cliente: " + e.getMessage());
        } finally {
            cerrarRecursos(statement, conexion);
        }
    }

    // Método para cerrar recursos
    private void cerrarRecursos(AutoCloseable... recursos) {
        for (AutoCloseable recurso : recursos) {
            if (recurso != null) {
                try {
                    recurso.close();
                } catch (Exception e) {
                    System.err.println("[ERROR] Error al cerrar recurso: " + e.getMessage());
                }
            }
        }
    }
}
