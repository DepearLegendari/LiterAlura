package com.alura.BoockSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRespuesta (
        Integer count,
        List<DatosLibro> results
){}
