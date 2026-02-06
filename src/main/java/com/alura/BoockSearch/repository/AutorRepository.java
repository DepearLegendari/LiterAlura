package com.alura.BoockSearch.repository;

import com.alura.BoockSearch.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {


    Optional<Autor> findByNombreIgnoreCase(String nombre);


    @Query("""
            SELECT a FROM Autor a
            WHERE a.nacimiento <= :anio
            AND (a.fallecimiento IS NULL OR a.fallecimiento > :anio)
            """)
    List<Autor> autoresVivosEnAnio(int anio);

}
