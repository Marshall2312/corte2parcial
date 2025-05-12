/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veterinaria.servicio;

/**
 *
 * @author LUIS POLO GARCIA
 */


import com.veterinaria.persistencia.Mascota;
import com.veterinaria.persistencia.MascotaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class MascotaServicio {
    private MascotaRepositorio mascotaRepositorio;

    public MascotaServicio() {
        this.mascotaRepositorio = new MascotaRepositorio();
    }

    // Método para registrar una mascota
    public boolean registrarMascota(Mascota mascota) throws Exception {
        if (mascota == null || mascota.getIdCliente() <= 0) {
            throw new Exception("La mascota no puede ser nula y debe tener un ID de cliente válido.");
        }
        return mascotaRepositorio.registrar(mascota);
    }

    // Método para listar todas las mascotas
public List<Mascota> listarMascotas() throws Exception {
    List<Mascota> mascotas = mascotaRepositorio.listar();
    if (mascotas == null) {
        mascotas = new ArrayList<>(); // Asegura que no se retorne null, sino una lista vacía
    }
    return mascotas;
}


    // Método para actualizar una mascota existente
    public boolean actualizarMascota(Mascota mascota) throws Exception {
        if (mascota == null || mascota.getIdMascota() <= 0) {
            throw new Exception("La mascota no puede ser nula y debe tener un ID válido.");
        }
        return mascotaRepositorio.actualizar(mascota);
    }

    // Método para eliminar una mascota por ID
    public boolean eliminarMascota(int idMascota) throws Exception {
        if (idMascota <= 0) {
            throw new Exception("El ID de la mascota debe ser mayor a cero.");
        }
        return mascotaRepositorio.eliminar(idMascota);
    }
}


