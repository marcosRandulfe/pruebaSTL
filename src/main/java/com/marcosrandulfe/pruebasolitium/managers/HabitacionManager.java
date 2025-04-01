package com.marcosrandulfe.pruebasolitium.managers;

import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import com.marcosrandulfe.pruebasolitium.requests.HabitacionRequest;

import java.util.List;

public interface HabitacionManager {
    void borrarHabitacion(Integer id);

    List<Habitacion> obtenerListadoHabitaciones();

    Habitacion obtenerHabitacion(Integer id);



    Habitacion crearHabitacion(HabitacionRequest habitacionRequest);

    Habitacion actualizarHabitacion(Habitacion habitacion);
}
