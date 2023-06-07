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

import com.proyecto.proyecto.modelo.Embalaje;
import com.proyecto.proyecto.repositrio.EmbalajeRepositorio;

@RestController
@RequestMapping("/Embalaje")
@CrossOrigin(origins = "*")

public class EmbalajeControlador {
    @Autowired
    private EmbalajeRepositorio Embalajerepositorio;

    @GetMapping("/listarEmbalaje")
    public List<Embalaje> listarTodoSlosAviones() {
        return Embalajerepositorio.findAll();
    }

    @PostMapping("/guardarEmbalaje")
    public Embalaje guardarReserva(@RequestBody Embalaje Embalaje) {
        return Embalajerepositorio.save(Embalaje);
    }

    @PutMapping("/actualizarEmbalaje/{id}")
    public Embalaje actualizarEmbalaje(@PathVariable int id, @RequestBody Embalaje EmbalajeActualizado) {
        Embalaje embalaje = Embalajerepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));

        embalaje.setCantidad_maletas(EmbalajeActualizado.getCantidad_maletas());
        embalaje.setPeso_maletas(EmbalajeActualizado.getPeso_maletas());
        embalaje.setPrecio_maletas(EmbalajeActualizado.getPrecio_maletas());

        Embalaje EmbalajevaActual = Embalajerepositorio.save(embalaje);
        return EmbalajevaActual;
    }

    @DeleteMapping("/eliminarEmbalaje/{id}")
    public String eliminarvuelo(@PathVariable int id) {
        Embalaje embalaje = Embalajerepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));
        Embalajerepositorio.delete(embalaje);
        return "Avion eliminado con el id: " + id;
    }
}
