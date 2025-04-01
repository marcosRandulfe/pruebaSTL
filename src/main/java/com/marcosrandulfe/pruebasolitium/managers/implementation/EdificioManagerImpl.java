package com.marcosrandulfe.pruebasolitium.managers.implementation;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;
import com.marcosrandulfe.pruebasolitium.managers.EdificioManager;
import com.marcosrandulfe.pruebasolitium.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioManagerImpl  implements EdificioManager {


    @Autowired
    private EdificioRepository edificioRepository;



    @Override
    public Edificio crearEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    @Override
    public List<Edificio> obtenerListadoEdificios() {
        return edificioRepository.findAll();
    }

    @Override
    public void borrarEdificio(Integer id) {
        edificioRepository.deleteById(id);
    }

    @Override
    public Edificio obtenerEdificio(Integer id) {
        return edificioRepository.findById(id).orElse(null);
    }


    @Override
    public Edificio actualizarEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }
}
