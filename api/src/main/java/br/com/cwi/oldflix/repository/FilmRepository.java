package br.com.cwi.oldflix.repository;

import br.com.cwi.oldflix.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
