package com.proyecto.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empleado;
    private String nombre;
    private Date fecha_nacimiento;
    private String telefono;
    private String direccion;
    private String genero;
    private String nacionalidad;
    private String cargo;

    // contructor vacio
    public empleado() {
    }

    // CONSTRUCTOR NORMAL
    public empleado(int id_empleado, String nombre, Date fecha_nacimiento, String telefono, String direccion,
            String genero, String nacionalidad, String cargo) {
        super();
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.cargo = cargo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
