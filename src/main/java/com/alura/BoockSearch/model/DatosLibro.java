package com.alura.BoockSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        Integer id,
        String title,
        List<DatosAutor> authors,
        @JsonProperty("language")
        List<String> lenguages,
        Integer download_count


) {
}
