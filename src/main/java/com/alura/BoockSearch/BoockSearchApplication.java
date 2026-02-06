package com.alura.BoockSearch;

import com.alura.BoockSearch.model.Libro;
import com.alura.BoockSearch.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BoockSearchApplication implements CommandLineRunner {

    private final LibroService libroService;

    public BoockSearchApplication(LibroService libroService) {
        this.libroService = libroService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BoockSearchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("""
                    1.- Buscar libro por titulo
                    2.- Listar libros
                    3.- Listar autores
                    4.- Autores vivos en un año
                    5.- Libros por idioma
                    0.- Salir
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Titulo del Llibro: ");
                    String titulo = teclado.nextLine();
                    libroService.buscarYGuardarLibro(titulo);
                }
                case 2 -> libroService.listarLibros()
                        .forEach(System.out::println);

                case 3 -> libroService.listarAutores()
                        .forEach(System.out::println);

                case 4 -> {
                    System.out.println("Año: ");
                    int anio = teclado.nextInt();
                    libroService.autoresVivosEnAnio(anio)
                            .forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Idioma (ej: en, es, fr, fi): ");
                    String idioma = teclado.nextLine().toLowerCase();

                    List<Libro> librosPorIdioma = libroService.buscarPorIdioma(idioma);

                    if (librosPorIdioma.isEmpty()) {
                        System.out.println("\n Libros en idioma: "+ idioma + "\n");
                    } else {
                        System.out.println("\n📚 Libros en idioma: " + idioma + "\n");
                        librosPorIdioma.forEach(libro -> {
                                    System.out.println("📖 Título: " + libro.getTitulo());
                                    System.out.println("✍️ Autor: " + libro.getAutor().getNombre());
                                    System.out.println("🌍 Idioma: " + libro.getIdioma());
                                    System.out.println("⬇️ Descargas: " + libro.getNumeroDescargas());
                                    System.out.println("-----------------------------");
                                });
                    }
                }

                case 0 -> System.out.println("👋 Hasta luego querido lector!");

                default -> System.out.println("❌ Opción inválida");
            }
        }
    }
}
