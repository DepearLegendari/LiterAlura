package com.alura.BoockSearch;

import com.alura.BoockSearch.model.DatosRespuesta;
import com.alura.BoockSearch.service.ConversorDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.BoockSearch.service.ConsumoAPI;

@SpringBootApplication
public class BoockSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoockSearchApplication.class, args);

        ConsumoAPI consumo = new ConsumoAPI();  // -> SOLO TRAE EL JSON, NÓ LO INTERPROTA
        ConversorDatos conversor = new ConversorDatos();


        String json = consumo.obtenerDatos(
                "https://gutendex.com/books/?search=dickens%20great"
        );

        DatosRespuesta datos =  conversor.obtenerDatos(json, DatosRespuesta.class);

        datos.results().forEach(libro -> System.out.println(libro.title())
        );
    }
}
