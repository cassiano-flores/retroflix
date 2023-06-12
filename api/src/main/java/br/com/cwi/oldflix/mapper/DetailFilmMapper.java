package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.response.DetailFilmResponse;
import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.domain.Situation;

import java.time.LocalDate;

public class DetailFilmMapper {

    public static DetailFilmResponse toResponse(Film film) {
        DetailFilmResponse response = new DetailFilmResponse();

        response.setId(film.getId());
        response.setTitle(film.getTitle());
        response.setDescription(film.getDescription());
        response.setAvailable(film.isAvailable());
        response.setCategory(film.getCategory());
        response.setResponsible(film.getResponsible());
        response.setCheckOutDate(film.getCheckOutDate());

        if (!film.isAvailable()) {
            response.setDeliveryDate(film.getDeliveryDate());

            Situation situation = Situation.status(LocalDate.now().isBefore(film.getDeliveryDate()));
            response.setSituation(situation);
        }

        return response;
    }
}
