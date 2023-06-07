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

import com.proyecto.proyecto.modelo.Vuelo;
import com.proyecto.proyecto.repositrio.Vuelorepositorio;

@RestController
@RequestMapping("/Vuelo")
@CrossOrigin(origins = "*")
public class Vuelocontrolador {
    @Autowired
    private Vuelorepositorio vuelorepositorio;

    @GetMapping("/listarVuelo")
    public List<Vuelo> listarTodoSlosAviones() {
        return vuelorepositorio.findAll();
    }

    @PostMapping("/guardarVuelo")
    public Vuelo guardarVuelo(@RequestBody Vuelo vuelo) {
        return vuelorepositorio.save(vuelo);
    }

    @PutMapping("/actualizarVuelo/{id}")
    public Vuelo actualizarPasajero(@PathVariable int id, @RequestBody Vuelo vueloActualizado) {
        Vuelo vuelo = vuelorepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));

        vuelo.setOrigen(vueloActualizado.getOrigen());
        vuelo.setFecha_salida(vueloActualizado.getFecha_salida());
        vuelo.setHora_salida(vueloActualizado.getHora_salida());
        vuelo.setDestino(vueloActualizado.getDestino());
        vuelo.setFecha_llegada(vueloActualizado.getFecha_llegada());
        vuelo.setHora_llegada(vueloActualizado.getHora_llegada());
        vuelo.setHora_revision(vueloActualizado.getHora_revision());
        vuelo.setNumero_puerta(vueloActualizado.getNumero_puerta());

        Vuelo vueloActual = vuelorepositorio.save(vuelo);
        return vueloActual;
    }

    @DeleteMapping("/eliminarVuelo/{id}")
    public String eliminarvuelo(@PathVariable int id) {
        Vuelo vuelo = vuelorepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));
        vuelorepositorio.delete(vuelo);
        return "Avion eliminado con el id: " + id;
    }

}
