package br.com.cwi.oldflix.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(name = "oldflix")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean available;
    private String responsible;

    @Enumerated(STRING)
    private Category category;

    @Enumerated(STRING)
    private Situation situation;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;
}
