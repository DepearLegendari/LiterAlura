package com.alura.BoockSearch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Integer numeroDescarga;

// 🔗 RELACION AUTOR -> LIBRO
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

// ° CONSTRUCTOR VACIO PARA GENERAR OBJETOS INTERNAMENTE
    public Libro() {}

// Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDescarga() {
        return numeroDescarga;
    }

    public void setNumeroDescarga(Integer numeroDescarga) {
        this.numeroDescarga = numeroDescarga;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}