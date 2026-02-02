package com.alura.BoockSearch.model;

import java.util.List;

public record DatosRespuesta (
        Integer count,
        List<DatosLibro> results
){}
