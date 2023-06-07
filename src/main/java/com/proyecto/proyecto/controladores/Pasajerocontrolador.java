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

import com.proyecto.proyecto.modelo.Pasajero;

import com.proyecto.proyecto.repositrio.repositoriopasajero;

@RestController
@RequestMapping("/Pasajero")
@CrossOrigin(origins = "*")

public class Pasajerocontrolador {
    @Autowired
    private repositoriopasajero repositoriopasajero;

    @GetMapping("/listarpasajero")
    public List<Pasajero> listarTodoSlosAviones() {
        return repositoriopasajero.findAll();
    }

    @PostMapping("/guardarPasajero")
    public Pasajero guardarAvion(@RequestBody Pasajero pasajero) {
        return repositoriopasajero.save(pasajero);
    }

    @PutMapping("/actualizarPasajero/{id}")
    public Pasajero actualizarPasajero(@PathVariable int id, @RequestBody Pasajero pasajeroActualizado) {
        Pasajero pasajero = repositoriopasajero.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));

        pasajero.setNacionalidad(pasajeroActualizado.getNacionalidad());
        pasajero.setGenero(pasajeroActualizado.getGenero());
        pasajero.setDireccion(pasajeroActualizado.getDireccion());
        pasajero.setTelefono(pasajeroActualizado.getTelefono());
        pasajero.setFecha_nacimiento(pasajeroActualizado.getFecha_nacimiento());
        pasajero.setNombre(pasajeroActualizado.getNombre());

        Pasajero pasajeroActual = repositoriopasajero.save(pasajero);
        return pasajeroActual;
    }

    @DeleteMapping("/eliminarPasajero/{id}")
    public String eliminarpasajero(@PathVariable int id) {
        Pasajero pasajero = repositoriopasajero.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));
        repositoriopasajero.delete(pasajero);
        return "Avion eliminado con el id: " + id + " nombre: " + pasajero.getNombre();
    }

}
