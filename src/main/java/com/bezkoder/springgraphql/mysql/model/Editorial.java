package com.bezkoder.springgraphql.mysql.model;

import javax.persistence.*;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "pais")
    private String pais;

    public Editorial() {
    }

    public Editorial(Long id) {
        this.id = id;
    }

    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Editorial [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
    }

}
