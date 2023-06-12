package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.response.GiveBackFilmResponse;
import br.com.cwi.oldflix.domain.Film;

public class GiveBackFilmMapper {

    public static GiveBackFilmResponse toResponse(Film film) {
        GiveBackFilmResponse response = new GiveBackFilmResponse();

        response.setId(film.getId());
        response.setTitle(film.getTitle());
        response.setDescription(film.getDescription());
        response.setAvailable(film.isAvailable());
        response.setCategory(film.getCategory());
        response.setResponsible(film.getResponsible());
        response.setCheckOutDate(film.getCheckOutDate());

        return response;
    }
}
