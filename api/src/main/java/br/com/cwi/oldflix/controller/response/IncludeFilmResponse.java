package br.com.cwi.oldflix.controller.response;

import br.com.cwi.oldflix.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IncludeFilmResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean available;
    private Category category;
    private String responsible;
    private LocalDate checkOutDate;
}
