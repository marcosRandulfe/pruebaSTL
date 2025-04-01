package com.marcosrandulfe.pruebasolitium.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "numero_plantas", nullable = false)
    private Integer numeroPlantas;

    @OneToMany(mappedBy = "edificio")
    private Set<Planta> plantas = new LinkedHashSet<>();

    public Set<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(Set<Planta> plantas) {
        this.plantas = plantas;
    }

    public Integer getNumeroPlantas() {
        return numeroPlantas;
    }

    public void setNumeroPlantas(Integer numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
