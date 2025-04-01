package com.marcosrandulfe.pruebasolitium.controlers;

import com.marcosrandulfe.pruebasolitium.entities.Planta;
import com.marcosrandulfe.pruebasolitium.managers.PlantaManager;
import com.marcosrandulfe.pruebasolitium.requests.RequestPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planta")
public class PlantaController {

    @Autowired
    private PlantaManager plantaManager;

    @GetMapping
    public List<Planta> getAllPlantas() {
        return plantaManager.obtenerListadoPlantas();
    }

    @GetMapping("/{id}")
    public Planta getPlantaById(@PathVariable Integer id) {
        return plantaManager.obtenerPlanta(id);
    }

    @PostMapping
    public Planta createPlanta(@RequestBody RequestPlanta planta) {
        return plantaManager.crearPlanta(planta);
    }

    @PutMapping("/{id}")
    public Planta updatePlanta(@PathVariable Integer id, @RequestBody Planta plantaDetails) {
        plantaDetails.setId(id);
        return plantaManager.actualizarPlanta(plantaDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePlanta(@PathVariable Integer id) {
        plantaManager.borrarPlanta(id);
    }
}
