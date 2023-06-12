package br.com.cwi.oldflix.controller;

import br.com.cwi.oldflix.controller.request.EditFilmRequest;
import br.com.cwi.oldflix.controller.request.IncludeFilmRequest;
import br.com.cwi.oldflix.controller.request.RentFilmRequest;
import br.com.cwi.oldflix.controller.response.*;
import br.com.cwi.oldflix.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*")
public class FilmController {

    @Autowired
    private ListFilmService listFilmService;

    @Autowired
    private DetailFilmService detailFilmService;

    @Autowired
    private IncludeFilmService includeFilmService;

    @Autowired
    private RentFilmService rentFilmService;

    @Autowired
    private GiveBackFilmService giveBackFilmService;

    @Autowired
    private EditFilmService editFilmService;

    @Autowired
    private RemoveFilmService removeFilmService;

    @GetMapping
    public List<ListFilmResponse> list() {
        return listFilmService.list();
    }

    @GetMapping("/{id}")
    public DetailFilmResponse detail(@PathVariable Long id) {
        return detailFilmService.detail(id);
    }

    @PostMapping
    public IncludeFilmResponse include(@Valid @RequestBody IncludeFilmRequest request) {
        return includeFilmService.include(request);
    }

    @PutMapping("/{id}/alugar")
    public RentFilmResponse rent(@Valid @RequestBody RentFilmRequest request, @PathVariable Long id) {
        return rentFilmService.rent(id, request);
    }

    @PutMapping("/{id}/devolver")
    public GiveBackFilmResponse giveBack(@PathVariable Long id) {
        return giveBackFilmService.giveBack(id);
    }

    @PutMapping("/{id}")
    public EditFilmResponse edit(@Valid @RequestBody EditFilmRequest request, @PathVariable Long id) {
        return editFilmService.edit(id, request);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        removeFilmService.remove(id);
    }
}
