package com.proyecto.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Avion;
    private int Capacidad;
    private String Nombre_Avion;
    private String Nombre_Modelo;

    // Constructor vacío
    public avion() {
    }

    // Constructor normal
    public avion(int id_Avion, String nombre_Avion, String nombre_Modelo, int capacidad) {
        this.Id_Avion = id_Avion;
        this.Nombre_Avion = nombre_Avion;
        this.Nombre_Modelo = nombre_Modelo;
        this.Capacidad = capacidad;
    }

    @JsonProperty("Id_Avion")
    public int getId_Avion() {
        return Id_Avion;
    }

    @JsonProperty("Id_Avion")
    public void setId_Avion(int Id_Avion) {
        this.Id_Avion = Id_Avion;
    }

    @JsonProperty("Capacidad")
    public int getCapacidad() {
        return Capacidad;
    }

    @JsonProperty("Capacidad")
    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    @JsonProperty("Nombre_Avion")
    public String getNombre_Avion() {
        return Nombre_Avion;
    }

    @JsonProperty("Nombre_Avion")
    public void setNombre_Avion(String Nombre_Avion) {
        this.Nombre_Avion = Nombre_Avion;
    }

    @JsonProperty("Nombre_Modelo")
    public String getNombre_Modelo() {
        return Nombre_Modelo;
    }

    @JsonProperty("Nombre_Modelo")
    public void setNombre_Modelo(String Nombre_Modelo) {
        this.Nombre_Modelo = Nombre_Modelo;
    }

}
