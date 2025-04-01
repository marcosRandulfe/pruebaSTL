package com.marcosrandulfe.pruebasolitium.managers;

import com.marcosrandulfe.pruebasolitium.entities.Planta;
import com.marcosrandulfe.pruebasolitium.requests.RequestPlanta;

import java.util.List;

public interface PlantaManager {
    Planta crearPlanta(RequestPlanta planta);

    List<Planta> obtenerListadoPlantas();

    Planta obtenerPlanta(Integer id);

    void borrarPlanta(Integer id);

    Planta actualizarPlanta(Planta planta);
}
