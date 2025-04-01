package com.marcosrandulfe.pruebasolitium.repositories;

import com.marcosrandulfe.pruebasolitium.entities.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PlantaRepository extends JpaRepository<Planta, Integer> {
}