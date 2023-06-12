package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.response.ListFilmResponse;
import br.com.cwi.oldflix.mapper.ListFilmMapper;
import br.com.cwi.oldflix.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public List<ListFilmResponse> list() {

        return filmRepository.findAll().stream()
                .map(ListFilmMapper::toResponse)
                .collect(toList());
    }
}
