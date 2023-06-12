package br.com.cwi.oldflix.controller.response;

import br.com.cwi.oldflix.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditFilmResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean available;
    private Category category;
}
