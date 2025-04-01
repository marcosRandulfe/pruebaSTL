package com.marcosrandulfe.pruebasolitium;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;
import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import com.marcosrandulfe.pruebasolitium.entities.Planta;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PruebaSolitiumApplicationTests {

    @Test
    void testEdificioHabitacionPlanta() {
        // Test for Edificio
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio A");
        edificio.setDireccion("123 Main St");
        edificio.setNumeroPlantas(3);

        assertEquals("Edificio A", edificio.getNombre());
        assertEquals("123 Main St", edificio.getDireccion());
        assertEquals(3, edificio.getNumeroPlantas());

        // Test for Planta
        Planta planta = new Planta();
        planta.setNombre("Planta 1");
        planta.setPiso(1);
        planta.setEdificio(edificio);

        assertEquals("Planta 1", planta.getNombre());
        assertEquals(1, planta.getPiso());
        assertEquals(edificio, planta.getEdificio());

        // Test for Habitacion
        Habitacion habitacion = new Habitacion();
        habitacion.setPlanta(planta);

        assertEquals(planta, habitacion.getPlanta());
    }

}
