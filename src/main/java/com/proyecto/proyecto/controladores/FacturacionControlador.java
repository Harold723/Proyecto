package com.proyecto.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.modelo.Facturacion;
import com.proyecto.proyecto.repositrio.facturacionRepositorio;

@RestController
@RequestMapping("/Facturacion")
@CrossOrigin(origins = "*")
public class FacturacionControlador {
    @Autowired
    private facturacionRepositorio facturacionrepositorio;

    // listar aviones
    @GetMapping("/listarFacturas")
    public List<Facturacion> listarTodoSlosAviones() {
        return facturacionrepositorio.findAll();
    }

    @PostMapping("/guardarFactura")
    public Facturacion guardarFactura(@RequestBody Facturacion facturacion) {
        return facturacionrepositorio.save(facturacion);
    }

    @PutMapping("/actualizarFactura/{id}")
    public Facturacion actualizarFacturacion(@PathVariable int id, @RequestBody Facturacion facturacionActualizado) {
        Facturacion facturacion = facturacionrepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la Facturacion con el id:" + id));

        // Actualizar los campos necesarios con los valores proporcionados en
        // facturacionActualizado
        facturacion.setNombre(facturacionActualizado.getNombre());
        facturacion.setNit(facturacionActualizado.getNit());
        facturacion.setDireccion(facturacionActualizado.getDireccion());

        Facturacion facturacionActual = facturacionrepositorio.save(facturacion);
        return facturacionActual;
    }

    @DeleteMapping("/eliminarFacturacion/{id}")
    public String eliminarFacturacion(@PathVariable int id) {
        Facturacion facturacion = facturacionrepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la factura con el id:" + id));
        facturacionrepositorio.delete(facturacion);
        return "Facturacion eliminada con el id: " + id;
    }

}
