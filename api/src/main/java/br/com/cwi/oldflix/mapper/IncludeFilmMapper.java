package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.request.IncludeFilmRequest;
import br.com.cwi.oldflix.controller.response.IncludeFilmResponse;
import br.com.cwi.oldflix.domain.Film;

public class IncludeFilmMapper {

    public static Film toEntity(IncludeFilmRequest request) {
        Film entity = new Film();

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setCategory(request.getCategory());

        return entity;
    }

    public static IncludeFilmResponse toResponse(Film entity) {
        IncludeFilmResponse response = new IncludeFilmResponse();

        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setAvailable(entity.isAvailable());
        response.setCategory(entity.getCategory());
        response.setResponsible(entity.getResponsible());
        response.setCheckOutDate(entity.getCheckOutDate());

        return response;
    }
}
