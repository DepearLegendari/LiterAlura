package com.alura.BoockSearch.repository;

import com.alura.BoockSearch.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
