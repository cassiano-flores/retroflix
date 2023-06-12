package br.com.cwi.oldflix.controller.request;

import br.com.cwi.oldflix.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IncludeFilmRequest {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Category is required")
    private Category category;
}
