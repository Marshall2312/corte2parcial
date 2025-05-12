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

public class Mascota {
    private int idMascota;
    private String nombre;
    private String raza;
    private int edad;
    private int idCliente;

    public Mascota(int idMascota, String nombre, String raza, int edad, int idCliente) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.idCliente = idCliente;
    }

    // Getters y setters
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}

