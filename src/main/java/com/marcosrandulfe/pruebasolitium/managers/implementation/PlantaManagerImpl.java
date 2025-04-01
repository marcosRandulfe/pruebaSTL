package com.marcosrandulfe.pruebasolitium.managers.implementation;

import com.marcosrandulfe.pruebasolitium.managers.PlantaManager;

import com.marcosrandulfe.pruebasolitium.entities.Planta;
import com.marcosrandulfe.pruebasolitium.repositories.EdificioRepository;
import com.marcosrandulfe.pruebasolitium.repositories.PlantaRepository;
import com.marcosrandulfe.pruebasolitium.requests.RequestPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaManagerImpl implements PlantaManager {

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    EdificioRepository edificioRepository;

    @Override
    public Planta crearPlanta(RequestPlanta planta) {
        Planta plantaObj = new Planta();
        plantaObj.setNombre(planta.getNombre());
        plantaObj.setPiso(planta.getPiso());
        plantaObj.setEdificio(edificioRepository.getReferenceById(planta.getEdificioId()));
        return plantaRepository.save(plantaObj);
    }

    @Override
    public List<Planta> obtenerListadoPlantas() {
        return (List<Planta>) plantaRepository.findAll();
    }

    @Override
    public Planta obtenerPlanta(Integer id) {
        return plantaRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarPlanta(Integer id) {
        plantaRepository.deleteById(id);
    }



    @Override
    public Planta actualizarPlanta(Planta planta) {
        return plantaRepository.save(planta);
    }
}