package com.marcosrandulfe.pruebasolitium.repositories;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}