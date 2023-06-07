package com.proyecto.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Embalaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_embalaje;
    private int cantidad_maletas;
    private Double peso_maletas;
    private Double precio_maletas;

    // Constructor vacío
    public Embalaje() {
    }

    // Constructor
    public Embalaje(int id_embalaje, int cantidad_maletas, Double peso_maletas, Double precio_maletas) {
        this.id_embalaje = id_embalaje;
        this.cantidad_maletas = cantidad_maletas;
        this.peso_maletas = peso_maletas;
        this.precio_maletas = precio_maletas;
    }

    // Getters y Setters
    public int getId_embalaje() {
        return id_embalaje;
    }

    public void setId_embalaje(int id_embalaje) {
        this.id_embalaje = id_embalaje;
    }

    public int getCantidad_maletas() {
        return cantidad_maletas;
    }

    public void setCantidad_maletas(int cantidad_maletas) {
        this.cantidad_maletas = cantidad_maletas;
    }

    public Double getPeso_maletas() {
        return peso_maletas;
    }

    public void setPeso_maletas(Double peso_maletas) {
        this.peso_maletas = peso_maletas;
    }

    public Double getPrecio_maletas() {
        return precio_maletas;
    }

    public void setPrecio_maletas(Double precio_maletas) {
        this.precio_maletas = precio_maletas;
    }
}
