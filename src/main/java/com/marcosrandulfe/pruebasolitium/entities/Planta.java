package com.marcosrandulfe.pruebasolitium.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "planta", schema = "mydatabase")
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "piso", nullable = false)
    private Integer piso;

    @OneToMany(mappedBy = "planta")
    private Set<Habitacion> habitacions = new LinkedHashSet<>();

    //TODO [Reverse Engineering] generate columns from DB
}