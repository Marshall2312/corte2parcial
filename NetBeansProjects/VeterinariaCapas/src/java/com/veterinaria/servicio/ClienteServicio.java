/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veterinaria.servicio;

import com.veterinaria.persistencia.Cliente;
import com.veterinaria.persistencia.ClienteRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio() {
        this.clienteRepositorio = new ClienteRepositorio();
    }

    public boolean registrarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        try {
            boolean resultado = clienteRepositorio.registrar(cliente);
            System.out.println("[INFO] Cliente registrado: " + resultado); // Depuración
            return resultado;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al registrar el cliente: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al registrar el cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() throws Exception {
        try {
            List<Cliente> clientes = clienteRepositorio.listar();
            if (clientes == null) {
                clientes = new ArrayList<>(); // Garantiza que nunca se devuelva null
            }
            System.out.println("[INFO] Clientes recuperados en el servicio: " + clientes.size()); // Depuración
            return clientes;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al listar clientes: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al listar clientes: " + e.getMessage());
        }
    }

    public boolean actualizarCliente(Cliente cliente) throws Exception {
        if (cliente == null || cliente.getIdCliente() <= 0) {
            throw new IllegalArgumentException("El cliente no puede ser nulo y debe tener un ID válido.");
        }
        try {
            boolean resultado = clienteRepositorio.actualizar(cliente);
            System.out.println("[INFO] Cliente actualizado: " + resultado); // Depuración
            return resultado;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al actualizar el cliente: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    public boolean eliminarCliente(int idCliente) throws Exception {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El ID del cliente debe ser mayor a cero.");
        }
        try {
            boolean resultado = clienteRepositorio.eliminar(idCliente);
            System.out.println("[INFO] Cliente eliminado: " + resultado); // Depuración
            return resultado;
        } catch (Exception e) {
            System.err.println("[ERROR] Error al eliminar el cliente: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
