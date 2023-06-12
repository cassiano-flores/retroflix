package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.response.DetailFilmResponse;
import br.com.cwi.oldflix.mapper.DetailFilmMapper;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class DetailFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public DetailFilmResponse detail(Long id) {

        return filmRepository.findById(id)
                .map(DetailFilmMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Film not found"));
    }
}
