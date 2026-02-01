package com.alura.BoockSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoAPI;

@SpringBootApplication
public class BoockSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoockSearchApplication.class, args);

        ConsumoAPI consumo = new ConsumoAPI();  // -> SOLO TRAE EL JSON, NÓ LO INTERPROTA
        String json = consumo.obtenerDatos(
                "https://gutendex.com/books/?search="
        );

        System.out.println(json);
	}

}
