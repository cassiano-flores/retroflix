package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.request.IncludeFilmRequest;
import br.com.cwi.oldflix.controller.response.IncludeFilmResponse;
import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.oldflix.mapper.IncludeFilmMapper.toEntity;
import static br.com.cwi.oldflix.mapper.IncludeFilmMapper.toResponse;

@Service
public class IncludeFilmService {

    @Autowired
    FilmRepository filmRepository;

    public IncludeFilmResponse include(IncludeFilmRequest request) {
        Film film = toEntity(request);

        film.setAvailable(true);

        filmRepository.save(film);

        return toResponse(film);
    }
}
