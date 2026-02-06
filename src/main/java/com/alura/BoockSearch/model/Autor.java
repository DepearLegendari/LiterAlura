package com.alura.BoockSearch.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;

// ° CONSTRUCTOR VACIO PARA GENERAR OBJETOS INTERNAMENTE
    protected Autor() {}

    public Autor(DatosAutor datos) {
        this.nombre = datos.name();
        this.nacimiento = datos.birth_year();
        this.fallecimiento = datos.death_year();
    }

// Getters y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }


@Override
    public String toString() {
        return """
                👤 Autor: %s
                🎂 Nacimiento: %d
                ⚰ Fallecimiento: %s
                """.formatted(
                        nombre,
                nacimiento,
                fallecimiento != null ? fallecimiento : "vivo"
        );
    }
}

