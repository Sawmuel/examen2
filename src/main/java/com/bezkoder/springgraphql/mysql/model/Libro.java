package com.bezkoder.springgraphql.mysql.model;

import javax.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "paginas")
    private Integer paginas;

    @Column(name = "edicion")
    private String edicion;

    @ManyToOne
    @JoinColumn(name = "idautor", nullable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "ideditorial", nullable = false, updatable = false)
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String titulo, String descripcion, Integer paginas, String edicion, Author author,
            Editorial editorial) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.paginas = paginas;
        this.edicion = edicion;
        this.author = author;
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", paginas=" + paginas
                + ", edicion=" + edicion + ", author=" + author + ", editorial=" + editorial + "]";
    }

}
