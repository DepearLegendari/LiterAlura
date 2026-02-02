package com.alura.BoockSearch.service;

import com.alura.BoockSearch.model.Autor;
import com.alura.BoockSearch.model.DatosAutor;
import com.alura.BoockSearch.model.DatosLibro;
import com.alura.BoockSearch.model.Libro;
import com.alura.BoockSearch.repository.AutorRepository;
import com.alura.BoockSearch.repository.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository,
                        AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }
    public void guardarLibro(DatosLibro datosLibro) {
        Autor autor = datosLibro.authors().stream()
                .findFirst()
                .map(this::obtenerAutor)
                .orElse(null);

        String idioma = "N/A";
        if (datosLibro.lenguages() != null && !datosLibro.lenguages().isEmpty()) {
            idioma = datosLibro.lenguages().get(0);
        }
        Libro libro = new Libro();
        libro.setTitulo(datosLibro.title());
        libro.setIdioma(idioma);
        libro.setNumeroDescarga(datosLibro.download_count());
        libro.setAutor(autor);

        libroRepository.save(libro);
    }

    private Autor obtenerAutor(DatosAutor datosAutor) {
        return autorRepository.findByNombreIgnoreCase(datosAutor.name())
                .orElseGet(() -> {
                    Autor autor = new Autor();
                    autor.setNombre(datosAutor.name());
                    autor.setAnioNacimiento(datosAutor.birth_year());
                    autor.setAnioFallecimiento(datosAutor.death_year());
                    return autorRepository.save(autor);
                });
    }
}
