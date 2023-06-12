package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.response.GiveBackFilmResponse;
import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.oldflix.mapper.GiveBackFilmMapper.toResponse;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GiveBackFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ValidateFilmUnavailableService validateFilmUnavailableService;

    public GiveBackFilmResponse giveBack(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Film not found"));

        validateFilmUnavailableService.validate(film);

        film.setAvailable(true);
        film.setCheckOutDate(null);
        film.setResponsible(null);
        film.setDeliveryDate(null);

        filmRepository.save(film);

        return toResponse(film);
    }
}
