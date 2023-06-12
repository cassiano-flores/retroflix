package br.com.cwi.oldflix.controller.request;

import br.com.cwi.oldflix.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditFilmRequest {

    private String title;
    private String description;
    private Category category;
}
