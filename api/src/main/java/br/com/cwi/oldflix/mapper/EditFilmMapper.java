package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.response.EditFilmResponse;
import br.com.cwi.oldflix.domain.Film;

public class EditFilmMapper {

    public static EditFilmResponse toResponse(Film film) {
        EditFilmResponse response = new EditFilmResponse();

        response.setId(film.getId());
        response.setTitle(film.getTitle());
        response.setDescription(film.getDescription());
        response.setAvailable(film.isAvailable());
        response.setCategory(film.getCategory());

        return response;
    }
}
