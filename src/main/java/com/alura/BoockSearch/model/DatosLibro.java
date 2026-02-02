package com.alura.BoockSearch.model;

import java.util.List;

public record DatosLibro(
        Integer id,
        String title,
        List<DatosAutor> authors,
        List<String> lenguages,
        Integer download_count


) {
}
