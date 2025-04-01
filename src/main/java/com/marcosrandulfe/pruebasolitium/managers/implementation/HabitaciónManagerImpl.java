package com.marcosrandulfe.pruebasolitium.managers.implementation;

import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import com.marcosrandulfe.pruebasolitium.managers.HabitacionManager;
import com.marcosrandulfe.pruebasolitium.repositories.HabitacionRepository;
import com.marcosrandulfe.pruebasolitium.repositories.PlantaRepository;
import com.marcosrandulfe.pruebasolitium.requests.HabitacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitaciónManagerImpl implements HabitacionManager {


    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private PlantaRepository plantaRepository;

    @Override
    public void borrarHabitacion(Integer id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public List<Habitacion> obtenerListadoHabitaciones() {
        return (List<Habitacion>) habitacionRepository.findAll();
    }


    @Override
    public Habitacion obtenerHabitacion(Integer id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Override
    public Habitacion crearHabitacion(HabitacionRequest habitacionRequest) {
        Habitacion habitacionObj = new Habitacion();
        habitacionObj.setPlanta(plantaRepository.getReferenceById(habitacionRequest.getPlantaId()));
        return habitacionRepository.save(habitacionObj);
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }
}
