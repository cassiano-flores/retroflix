package br.com.cwi.oldflix.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RentFilmRequest {

    @NotBlank(message = "Responsible is required")
    private String responsible;
}
