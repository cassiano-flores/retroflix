package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.request.RentFilmRequest;
import br.com.cwi.oldflix.controller.response.RentFilmResponse;
import br.com.cwi.oldflix.domain.Category;
import br.com.cwi.oldflix.domain.Film;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static br.com.cwi.oldflix.mapper.RentFilmMapper.toResponse;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RentFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ValidateFilmAvailableService validateFilmAvailableService;

    public RentFilmResponse rent(Long id, RentFilmRequest request) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Film not found"));

        validateFilmAvailableService.validate(film);

        film.setAvailable(false);
        film.setCheckOutDate(LocalDate.now());
        film.setResponsible(request.getResponsible());

        Category category = Category.valueOf(film.getCategory().toString());
        film.setDeliveryDate(category.getExpirationDate(film.getCheckOutDate()));

        filmRepository.save(film);

        return toResponse(film);
    }
}
