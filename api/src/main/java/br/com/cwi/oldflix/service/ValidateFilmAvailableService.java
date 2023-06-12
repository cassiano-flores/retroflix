package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.domain.Film;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidateFilmAvailableService {

    public void validate(Film film) {

        if (!film.isAvailable()) {
            throw new ResponseStatusException(BAD_REQUEST, "The film is not available");
        }
    }
}
