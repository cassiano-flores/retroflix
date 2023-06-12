package br.com.cwi.oldflix.controller.response;

import br.com.cwi.oldflix.domain.Category;
import br.com.cwi.oldflix.domain.Situation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DetailFilmResponse {

    private Long id;
    private String title;
    private String description;
    private boolean available;
    private Category category;
    private String responsible;
    private LocalDate checkOutDate;
    private LocalDate deliveryDate;
    private Situation situation;
}
