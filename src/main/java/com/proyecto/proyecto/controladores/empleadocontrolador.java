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

import com.proyecto.proyecto.modelo.empleado;
import com.proyecto.proyecto.repositrio.repositorioempleado;

@RestController
@RequestMapping("/Empleado")
// @CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200/")

public class empleadocontrolador {
    @Autowired
    private repositorioempleado repositorioempleado;

    @GetMapping("/listarempleado")
    public List<empleado> listarTodoSlosAviones() {
        return repositorioempleado.findAll();
    }

    @PostMapping("/guardarEmpleado")
    public empleado guardarAvion(@RequestBody empleado empleado) {
        return repositorioempleado.save(empleado);
    }

    @PutMapping("/actualizarEmpleado/{id}")
    public empleado actualizarEmpleado(@PathVariable int id, @RequestBody empleado empleadoActualizado) {

        empleado empleado = repositorioempleado.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con el id:" + id));

        empleado.setCargo(empleadoActualizado.getCargo());
        empleado.setDireccion(empleadoActualizado.getDireccion());
        empleado.setFecha_nacimiento(empleadoActualizado.getFecha_nacimiento());
        empleado.setGenero(empleadoActualizado.getGenero());
        empleado.setNacionalidad(empleadoActualizado.getNacionalidad());
        empleado.setNombre(empleadoActualizado.getNombre());
        empleado.setTelefono(empleadoActualizado.getTelefono());

        empleado empleadoActual = repositorioempleado
                .save(empleado);
        return empleadoActual;
    }

    @DeleteMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        empleado empleado = repositorioempleado.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con elid: " + id));
        repositorioempleado.delete(empleado);
        return "Avion eliminado con el id: " + id + " nombre: " +
                empleado.getNombre();
    }

}
