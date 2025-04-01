package com.marcosrandulfe.pruebasolitium;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;
import com.marcosrandulfe.pruebasolitium.entities.Planta;
import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import com.marcosrandulfe.pruebasolitium.repositories.EdificioRepository;
import com.marcosrandulfe.pruebasolitium.repositories.HabitacionRepository;
import com.marcosrandulfe.pruebasolitium.repositories.PlantaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PruebasIntegridad {

    @Autowired
    EdificioRepository edificioRepository;

    @Autowired
    PlantaRepository plantaRepository;

    @Autowired
    HabitacionRepository habitacionRepository;

    @Test
    public void pruebaIntegridadEdificio() {
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio de prueba");
        edificio.setDireccion("Calle de prueba");
        edificio.setNumeroPlantas(10);

        Edificio edificioCreado = edificioRepository.save(edificio);

        assertNotNull(edificioCreado);
        assertEquals(edificio.getNombre(), edificioCreado.getNombre());
        assertEquals(edificio.getDireccion(), edificioCreado.getDireccion());
        assertEquals(edificio.getNumeroPlantas(), edificioCreado.getNumeroPlantas());
    }

    @Test
    public void pruebaIntegridadPlanta() {
        Planta planta = new Planta();
        planta.setNombre("Planta de prueba");
        planta.setPiso(1);
        planta.setEdificio(edificioRepository.findAll().get(0));

        Planta plantaCreada = plantaRepository.save(planta);

        assertNotNull(plantaCreada);
        assertEquals(planta.getNombre(), plantaCreada.getNombre());
        assertEquals(planta.getPiso(), plantaCreada.getPiso());
        assertEquals(planta.getEdificio().getId(), plantaCreada.getEdificio().getId());
    }

    @Test
    public void pruebaIntegridadHabitacion() {
        Habitacion habitacion = new Habitacion();
        habitacion.setPlanta(plantaRepository.findAll().get(0));
        Habitacion habitacionCreada = habitacionRepository.save(habitacion);
        assertNotNull(habitacionCreada);
        assertEquals(habitacion.getPlanta().getId(), habitacionCreada.getPlanta().getId());
    }
}
