package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.response.RentFilmResponse;
import br.com.cwi.oldflix.domain.Film;

public class RentFilmMapper {

    public static RentFilmResponse toResponse(Film film) {
        RentFilmResponse response = new RentFilmResponse();

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
