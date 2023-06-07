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

import com.proyecto.proyecto.modelo.Reserva;
import com.proyecto.proyecto.repositrio.repositorioreserva;

@RestController
@RequestMapping("/Reserva")
@CrossOrigin(origins = "*")
public class reservacontralador {
    @Autowired
    private repositorioreserva repositorioreserva;

    @GetMapping("/listarReserva")
    public List<Reserva> listarTodoSlosAviones() {
        return repositorioreserva.findAll();
    }

    @PostMapping("/guardarReserva")
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return repositorioreserva.save(reserva);
    }

    @PutMapping("/actualizarReserva/{id}")
    public Reserva actualizarPasajero(@PathVariable int id, @RequestBody Reserva reservaActualizado) {
        Reserva reserva = repositorioreserva.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));

        reserva.setClase_vuelo(reservaActualizado.getClase_vuelo());
        reserva.setAsiento(reservaActualizado.getAsiento());
        reserva.setFk_id_vuelo(reservaActualizado.getFk_id_vuelo());
        reserva.setFk_id_pasajero(reservaActualizado.getFk_id_pasajero());

        Reserva reservaActual = repositorioreserva.save(reserva);
        return reservaActual;
    }

    @DeleteMapping("/eliminarReserva/{id}")
    public String eliminarvuelo(@PathVariable int id) {
        Reserva reserva = repositorioreserva.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));
        repositorioreserva.delete(reserva);
        return "Avion eliminado con el id: " + id;
    }

}
