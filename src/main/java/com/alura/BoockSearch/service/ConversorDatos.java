package com.alura.BoockSearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDatos {

    private  ObjectMapper mapper= new ObjectMapper();

    public <T> T obtenerDatos(String json, Class<T> clase){
        try {
            return mapper.readValue(json, clase);
        } catch (Exception e){
            throw new RuntimeException("Error al convertir JSON", e);
        }
    }
}
