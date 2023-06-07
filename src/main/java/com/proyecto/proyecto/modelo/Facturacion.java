package com.proyecto.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")

public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero_factura;
    private String nombre;
    private String nit;
    private String direccion;
    private Date fecha_emision;

    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boleto id_boleto;

    @ManyToOne
    @JoinColumn(name = "id_embalaje")
    private Embalaje id_embalaje;

    // Constructor vacío
    public Facturacion() {
    }

    // Constructor
    public Facturacion(int numero_factura, String nombre, String nit, String direccion, Date fecha_emision,
            Boleto id_boleto, Embalaje id_embalaje) {
        this.numero_factura = numero_factura;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.fecha_emision = fecha_emision;
        this.id_boleto = id_boleto;
        this.id_embalaje = id_embalaje;
    }

    // Getters y Setters
    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Boleto getId_boleto() {
        return id_boleto;
    }

    public void setId_boleto(Boleto id_boleto) {
        this.id_boleto = id_boleto;
    }

    public Embalaje getId_embalaje() {
        return id_embalaje;
    }

    public void setId_embalaje(Embalaje id_embalaje) {
        this.id_embalaje = id_embalaje;
    }
}
