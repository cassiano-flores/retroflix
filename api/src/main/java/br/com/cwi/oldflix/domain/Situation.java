package br.com.cwi.oldflix.domain;

public enum Situation {

    UP_TO_DATE,
    LATE;

    Situation() {
    }

    public static Situation status(boolean isUpToDate) {
        return isUpToDate ? UP_TO_DATE : LATE;
    }
}
