package com.alura.BoockSearch.service;

import com.alura.BoockSearch.model.*;
import com.alura.BoockSearch.repository.AutorRepository;
import com.alura.BoockSearch.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private static final String URL_BASE = "https://gutendex.com/books/?search=";

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConversorDatos conversor = new ConversorDatos();

    public LibroService(LibroRepository libroRepository,
                        AutorRepository autorRepository,
                        ConsumoAPI consumoAPI,
                        ConversorDatos conversor) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.consumoAPI = consumoAPI;
        this.conversor = conversor;
    }

    // 🔎 CASE 1 - Buscar libro por título
    public void buscarYGuardarLibro(String titulo) {

        String json = consumoAPI.obtenerDatos(
                URL_BASE + titulo.replace(" ", "%20")
        );

        DatosRespuesta respuesta = conversor.obtenerDatos(json, DatosRespuesta.class);

        if (respuesta.results().isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }

        DatosLibro datosLibro = respuesta.results().get(0);
        DatosAutor datosAutor = datosLibro.authors().get(0);

        Autor autor = autorRepository
                .findByNombreIgnoreCase(datosAutor.name())
                .orElseGet(() ->
                        autorRepository.save(new Autor(datosAutor))
                );

        String idioma = "Desconocido";
        if (!datosLibro.idioma().isEmpty()) {
            idioma = datosLibro.idioma().get(0);
        }

        Libro libro = new Libro(datosLibro, autor, idioma);
        libroRepository.save(libro);

        System.out.println("✅ Libro guardado correctamente");
    }

    // 📚 CASE 2 - Listar libros
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // 👤 CASE 3 - Listar autores
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // 📅 CASE 4 - Autores vivos en un año
    public List<Autor> autoresVivosEnAnio(int anio)  {
        return autorRepository.autoresVivosEnAnio(anio);
    }

    // 🌍 CASE 5 - Libros por idioma
    public List<Libro> buscarPorIdioma(String idioma) {
            return libroRepository.findByIdioma(idioma);

    }
}
