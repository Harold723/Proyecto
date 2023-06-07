package com.proyecto.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String origen;
    private Date fecha_salida;
    private Time hora_salida;
    private String destino;
    private Date fecha_llegada;
    private Time hora_llegada;
    private Time hora_revision;
    private String numero_puerta;

    @ManyToOne
    @JoinColumn(name = "Fk_Id_Avion")
    private avion FK_Id_Avion;

    // Constructor
    public Vuelo() {
    }

    public Vuelo(int id, String origen, Date fecha_salida, Time hora_salida, String destino, Date fecha_llegada,
            Time hora_llegada, Time hora_revision, String numero_puerta, avion fk_Id_Avion) {
        this.id = id;
        this.origen = origen;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.destino = destino;
        this.fecha_llegada = fecha_llegada;
        this.hora_llegada = hora_llegada;
        this.hora_revision = hora_revision;
        this.numero_puerta = numero_puerta;
        FK_Id_Avion = fk_Id_Avion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public Time getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Time getHora_revision() {
        return hora_revision;
    }

    public void setHora_revision(Time hora_revision) {
        this.hora_revision = hora_revision;
    }

    public String getNumero_puerta() {
        return numero_puerta;
    }

    public void setNumero_puerta(String numero_puerta) {
        this.numero_puerta = numero_puerta;
    }

    public avion getFK_Id_Avion() {
        return FK_Id_Avion;
    }

    public void setFK_Id_Avion(avion fk_Id_Avion) {
        FK_Id_Avion = fk_Id_Avion;
    }
}
