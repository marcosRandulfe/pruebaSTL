package com.marcosrandulfe.pruebasolitium.repositories;

import com.marcosrandulfe.pruebasolitium.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
}