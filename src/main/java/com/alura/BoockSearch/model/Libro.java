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
    private Integer numeroDescargas;

// 🔗 RELACION AUTOR -> LIBRO
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

// ° CONSTRUCTOR VACIO PARA GENERAR OBJETOS INTERNAMENTE JPA
    protected Libro(){
}

//  Constructor personalizado
    public Libro(DatosLibro datos, Autor autor, String idioma) {
        this.titulo = datos.title();
        this.numeroDescargas = datos.download_count();
        this.idioma = idioma;
        this.autor = autor;
    }

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

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String nombreAutor = (autor != null) ? autor.getNombre() : "Desconocido";

                return """
                📘 Título: %s
                🌍 Idioma: %s
                ⬇ Descargas: %d
                ✍ Autor: %s
                """.formatted(titulo, idioma, numeroDescargas, nombreAutor);
    }
}