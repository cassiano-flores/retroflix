package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.request.EditFilmRequest;
import br.com.cwi.oldflix.controller.response.EditFilmResponse;
import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static br.com.cwi.oldflix.mapper.EditFilmMapper.toResponse;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EditFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ValidateFilmAvailableService validateFilmAvailableService;

    public EditFilmResponse edit(Long id, EditFilmRequest request) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Film not found"));

        validateFilmAvailableService.validate(film);

        film.setTitle(Objects.requireNonNullElse(request.getTitle(), film.getTitle()));
        film.setDescription(Objects.requireNonNullElse(request.getDescription(), film.getDescription()));
        film.setCategory(Objects.requireNonNullElse(request.getCategory(), film.getCategory()));

        filmRepository.save(film);

        return toResponse(film);
    }
}
