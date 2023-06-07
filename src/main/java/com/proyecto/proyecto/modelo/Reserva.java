package com.proyecto.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clase_vuelo;
    private String asiento;

    @ManyToOne
    @JoinColumn(name = "Fk_id_vuelo")
    private Vuelo Fk_id_vuelo;

    @ManyToOne
    @JoinColumn(name = "Fk_id_pasajero")
    private Pasajero Fk_id_pasajero;

    // Constructor
    public Reserva() {
    }

    public Reserva(int id, String clase_vuelo, String asiento, Pasajero fk_id_pasajero, Vuelo fk_id_vuelo) {
        this.id = id;
        this.clase_vuelo = clase_vuelo;
        this.asiento = asiento;
        Fk_id_pasajero = fk_id_pasajero;
        Fk_id_vuelo = fk_id_vuelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClase_vuelo() {
        return clase_vuelo;
    }

    public void setClase_vuelo(String clase_vuelo) {
        this.clase_vuelo = clase_vuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Vuelo getFk_id_vuelo() {
        return Fk_id_vuelo;
    }

    public void setFk_id_vuelo(Vuelo fk_id_vuelo) {
        Fk_id_vuelo = fk_id_vuelo;
    }

    public Pasajero getFk_id_pasajero() {
        return Fk_id_pasajero;
    }

    public void setFk_id_pasajero(Pasajero fk_id_pasajero) {
        Fk_id_pasajero = fk_id_pasajero;
    }

}
