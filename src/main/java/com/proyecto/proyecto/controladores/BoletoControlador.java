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

import com.proyecto.proyecto.modelo.Boleto;
import com.proyecto.proyecto.repositrio.BoletoRepositorio;

@RestController
@RequestMapping("/Boletos")
@CrossOrigin(origins = "*")

public class BoletoControlador {
    @Autowired
    private BoletoRepositorio Boletorepositorio;

    @GetMapping("/listarBoleto")
    public List<Boleto> listarTodoSlosAviones() {
        return Boletorepositorio.findAll();
    }

    @PostMapping("/InsertarBoleto")
    public Boleto guardarAvion(@RequestBody Boleto boleto) {
        return Boletorepositorio.save(boleto);

    }

    @PutMapping("/actualizarBoleto/{id}")
    public Boleto actualizarPasajero(@PathVariable int id, @RequestBody Boleto BoletoActualizado) {
        Boleto boleto = Boletorepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));

        boleto.setFecha_emision(BoletoActualizado.getFecha_emision());
        boleto.setFecha_validacion(BoletoActualizado.getFecha_validacion());
        boleto.setHora_prechequeo(BoletoActualizado.getHora_prechequeo());
        boleto.setPrecio_boleto(BoletoActualizado.getPrecio_boleto());
        boleto.setFk_id_reserva(BoletoActualizado.getFk_id_reserva());

        Boleto BoletoActual = Boletorepositorio.save(boleto);
        return BoletoActual;
    }

    @DeleteMapping("/eliminarBoleto/{id}")
    public String eliminarBoleto(@PathVariable int id) {
        Boleto boleto = Boletorepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el boleto con el id:" + id));
        Boletorepositorio.delete(boleto);
        return "Avion eliminado con el id: " + id;
    }
}
