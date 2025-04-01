package com.marcosrandulfe.pruebasolitium.controlers;

import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import com.marcosrandulfe.pruebasolitium.managers.HabitacionManager;
import com.marcosrandulfe.pruebasolitium.requests.HabitacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {


    @Autowired
    private HabitacionManager habitacionManager;

    @GetMapping
    public List<Habitacion> getAllHabitaciones() {
        return habitacionManager.obtenerListadoHabitaciones();
    }

    @GetMapping("/{id}")
    public Habitacion getHabitacionById(@PathVariable Integer id) {
        return habitacionManager.obtenerHabitacion(id);
    }

    @PostMapping
    public Habitacion createHabitacion(@RequestBody HabitacionRequest habitacion) {
        return habitacionManager.crearHabitacion(habitacion);
    }

    @PutMapping("/{id}")
    public Habitacion updateHabitacion(@PathVariable Integer id, @RequestBody Habitacion habitacion) {
        habitacion.setId(id);
        return habitacionManager.actualizarHabitacion(habitacion);
    }

    @DeleteMapping("/{id}")
    public void deleteHabitacion(@PathVariable Integer id) {
        habitacionManager.borrarHabitacion(id);
    }
}
