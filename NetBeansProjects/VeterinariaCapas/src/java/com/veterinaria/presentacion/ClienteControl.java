/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veterinaria.presentacion;

import com.veterinaria.servicio.ClienteServicio;
import com.veterinaria.persistencia.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ClienteControl extends HttpServlet {
    private ClienteServicio clienteServicio;

    @Override
    public void init() throws ServletException {
        this.clienteServicio = new ClienteServicio();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null || accion.trim().isEmpty()) {
                mostrarAlerta(response, "Error: La acción no puede ser nula o vacía.");
                return;
            }
            switch (accion.toLowerCase()) {
                case "registrar":
                    registrarCliente(request, response);
                    break;
                case "actualizar":
                    actualizarCliente(request, response);
                    break;
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                default:
                    mostrarAlerta(response, "Acción no reconocida: " + accion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error en doPost: " + e.getMessage());
        }
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener la lista de clientes desde el servicio
            List<Cliente> clientes = clienteServicio.listarClientes();

            // Verificar que la lista no sea nula o vacía
            if (clientes != null && !clientes.isEmpty()) {
                System.out.println("[INFO] Clientes enviados: " + clientes.size()); // Depuración
                request.setAttribute("clientes", clientes);
            } else {
                System.out.println("[INFO] No hay clientes para mostrar."); // Depuración
                request.setAttribute("clientes", null);
            }

            // Redirigir al JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarClientes.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            // Manejo de errores mejorado con logs detallados
            System.err.println("[ERROR] Error al listar clientes: " + e.getMessage());
            e.printStackTrace(); // Depuración
            mostrarAlerta(response, "Error al listar clientes: " + e.getMessage());
        }
    }


    private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");

            Cliente cliente = new Cliente(0, nombre, apellido, direccion, telefono);
            if (clienteServicio.registrarCliente(cliente)) {
                mostrarAlerta(response, "Cliente registrado correctamente.");
            } else {
                mostrarAlerta(response, "Error al registrar cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al registrar cliente: " + e.getMessage());
        }
    }

    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");

            Cliente cliente = new Cliente(idCliente, nombre, apellido, direccion, telefono);
            if (clienteServicio.actualizarCliente(cliente)) {
                mostrarAlerta(response, "Cliente actualizado correctamente.");
            } else {
                mostrarAlerta(response, "Error al actualizar cliente.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarAlerta(response, "ID Cliente inválido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al actualizar cliente: " + e.getMessage());
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            if (clienteServicio.eliminarCliente(idCliente)) {
                mostrarAlerta(response, "Cliente eliminado correctamente.");
            } else {
                mostrarAlerta(response, "Error al eliminar cliente.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarAlerta(response, "ID Cliente inválido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al eliminar cliente: " + e.getMessage());
        }
    }

    private void mostrarAlerta(HttpServletResponse response, String mensaje) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type='text/javascript'>");
        response.getWriter().println("alert('" + mensaje + "');");
        response.getWriter().println("window.location.href = 'FormCliente.jsp';");
        response.getWriter().println("</script>");
    }
}


