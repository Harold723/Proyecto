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

import com.proyecto.proyecto.modelo.avion;
import com.proyecto.proyecto.repositrio.repositorio;

@RestController
@RequestMapping("/Aviones")
@CrossOrigin(origins = "*")

public class avioncontrolador {
    @Autowired
    private repositorio repositorio;

    // listar aviones
    @GetMapping("/listarAviones")
    public List<avion> listarTodoSlosAviones() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarAviones")
    public avion guardarAvion(@RequestBody avion avion) {
        return repositorio.save(avion);
    }

    @PutMapping("/actualizarAvion/{id}")
    public avion actualizarAvion(@PathVariable int id, @RequestBody avion avionActualizado) {

        avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));

        avion.setNombre_Avion(avionActualizado.getNombre_Avion());
        avion.setNombre_Modelo(avionActualizado.getNombre_Modelo());
        avion.setCapacidad(avionActualizado.getCapacidad());

        avion avionActual = repositorio.save(avion);
        return avionActual;
    }

    @DeleteMapping("/eliminarAvion/{id}")
    public String eliminarAvion(@PathVariable int id) {
        avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id: " + id));
        repositorio.delete(avion);
        return "Avion eliminado con el id: " + id + " nombre: " + avion.getNombre_Avion();
    }

}
