/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veterinaria.presentacion;

/**
 *
 * @author LUIS POLO GARCIA
 */

import com.veterinaria.servicio.MascotaServicio;
import com.veterinaria.persistencia.Mascota;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class MascotaControl extends HttpServlet {
    private MascotaServicio mascotaServicio;

    @Override
    public void init() throws ServletException {
        this.mascotaServicio = new MascotaServicio();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null || accion.trim().isEmpty()) {
                mostrarAlerta(response, "Error: La acción no puede ser nula o vacía.");
                return;
            }

            switch (accion.toLowerCase()) {
                case "registrar":
                    registrarMascota(request, response);
                    break;
                case "actualizar":
                    actualizarMascota(request, response);
                    break;
                case "eliminar":
                    eliminarMascota(request, response);
                    break;
                default:
                    mostrarAlerta(response, "Acción no reconocida: " + accion);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error en doPost: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Mascota> mascotas = mascotaServicio.listarMascotas();

            if (mascotas == null || mascotas.isEmpty()) {
                System.out.println("[INFO] No hay mascotas para mostrar."); // Depuración
                request.setAttribute("mascotas", null);
            } else {
                System.out.println("[INFO] Mascotas enviadas: " + mascotas.size()); // Depuración
                request.setAttribute("mascotas", mascotas);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarMascotas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al listar mascotas: " + e.getMessage());
        }
    }

    private void registrarMascota(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombre = request.getParameter("nombre");
            String raza = request.getParameter("raza");
            String edadParam = request.getParameter("edad");
            String idClienteParam = request.getParameter("idCliente");

            int edad = Integer.parseInt(edadParam);
            int idCliente = Integer.parseInt(idClienteParam);

            Mascota mascota = new Mascota(0, nombre, raza, edad, idCliente);
            if (mascotaServicio.registrarMascota(mascota)) {
                mostrarAlerta(response, "Mascota registrada correctamente.");
            } else {
                mostrarAlerta(response, "Error al registrar mascota.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error: Parámetros numéricos inválidos. " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al registrar mascota: " + e.getMessage());
        }
    }

    private void actualizarMascota(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int idMascota = Integer.parseInt(request.getParameter("idMascota"));
            String nombre = request.getParameter("nombre");
            String raza = request.getParameter("raza");
            int edad = Integer.parseInt(request.getParameter("edad"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));

            Mascota mascota = new Mascota(idMascota, nombre, raza, edad, idCliente);
            if (mascotaServicio.actualizarMascota(mascota)) {
                mostrarAlerta(response, "Mascota actualizada correctamente.");
            } else {
                mostrarAlerta(response, "Error al actualizar mascota.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error: Parámetros numéricos inválidos. " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al actualizar mascota: " + e.getMessage());
        }
    }

    private void eliminarMascota(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int idMascota = Integer.parseInt(request.getParameter("idMascota"));
            if (mascotaServicio.eliminarMascota(idMascota)) {
                mostrarAlerta(response, "Mascota eliminada correctamente.");
            } else {
                mostrarAlerta(response, "Error al eliminar mascota.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error: Parámetro 'idMascota' inválido. " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(response, "Error al eliminar mascota: " + e.getMessage());
        }
    }

    private void mostrarAlerta(HttpServletResponse response, String mensaje) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type='text/javascript'>");
        response.getWriter().println("alert('" + mensaje + "');");
        response.getWriter().println("window.location.href = 'FormMascota.jsp';");
        response.getWriter().println("</script>");
    }
}


