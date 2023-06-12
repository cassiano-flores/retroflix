package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RemoveFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ValidateFilmAvailableService validateFilmAvailableService;

    public void remove(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Film not found"));

        validateFilmAvailableService.validate(film);

        filmRepository.deleteById(id);
    }
}
