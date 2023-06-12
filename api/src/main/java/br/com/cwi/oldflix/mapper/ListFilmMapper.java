package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.response.ListFilmResponse;
import br.com.cwi.oldflix.domain.Film;

public class ListFilmMapper {

    public static ListFilmResponse toResponse(Film entity) {
        ListFilmResponse response = new ListFilmResponse();

        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setAvailable(entity.isAvailable());
        response.setCategory(entity.getCategory());

        return response;
    }
}
