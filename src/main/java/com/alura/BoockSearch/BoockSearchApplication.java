package com.alura.BoockSearch;

import com.alura.BoockSearch.model.DatosLibro;
import com.alura.BoockSearch.model.DatosRespuesta;
import com.alura.BoockSearch.repository.AutorRepository;
import com.alura.BoockSearch.service.ConversorDatos;
import com.alura.BoockSearch.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.BoockSearch.service.ConsumoAPI;

@SpringBootApplication
public class BoockSearchApplication implements CommandLineRunner {

    private final ConsumoAPI consumoAPI;
    private final ConversorDatos conversorDatos;
    private final LibroService libroService;

    public BoockSearchApplication(
            ConsumoAPI consumoAPI,
            ConversorDatos conversorDatos,
            LibroService libroService) {
     this.consumoAPI = consumoAPI;
     this.conversorDatos = conversorDatos;
     this.libroService = libroService;
    }

	public static void main(String[] args) {
        SpringApplication.run(BoockSearchApplication.class, args);
    }

    @Override
    public void run(String... args) {

        String URL = "https://gutendex.com/books/?search=java";
        String json = consumoAPI.obtenerDatos(URL);
        DatosRespuesta respuesta =
                conversorDatos.obtenerDatos(json, DatosRespuesta.class);
        for (DatosLibro datosLibro : respuesta.results()) {
            libroService.guardarLibro(datosLibro);
        }

         System.out.println("📚 Libros guardados correctamente en la base de datos 💙");
    }
}
