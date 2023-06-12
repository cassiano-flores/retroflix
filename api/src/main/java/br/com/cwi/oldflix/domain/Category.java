package br.com.cwi.oldflix.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Category {
    BRONZE(5),
    SILVER(3),
    GOLD(2);

    private final int days;

    Category(int days) {
        this.days = days;
    }

    public LocalDate getExpirationDate(LocalDate startDate) {
        return startDate.plus(days, ChronoUnit.DAYS);
    }
}
