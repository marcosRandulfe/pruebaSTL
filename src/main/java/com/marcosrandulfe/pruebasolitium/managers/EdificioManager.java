package com.marcosrandulfe.pruebasolitium.managers;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;

import java.util.List;

public interface EdificioManager {

    Edificio crearEdificio(Edificio edificio);

    List<Edificio> obtenerListadoEdificios();

    void borrarEdificio(Integer id);

    Edificio obtenerEdificio(Integer id);

    Edificio actualizarEdificio(Edificio edificio);
}
