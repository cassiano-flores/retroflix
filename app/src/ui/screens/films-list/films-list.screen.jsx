import './films-list.style.css';
import { useEffect } from 'react';
import { getListFilms } from '../../../api';
import { CardFilm } from '../../components/card-film/card-film.component';
import { ScreenWrapper } from '../../components';
import useGlobalFilm from '../../../context/films/film.context';

export function FilmsListScreen() {
  const [films, setFilms] = useGlobalFilm();

  async function fetchFilms() {
    const response = await getListFilms();
    setFilms(response);
  }

  useEffect(() => {
    fetchFilms();
  }, []);

  useEffect(() => {
    fetchFilms();
  }, [films]);

  return (
    <ScreenWrapper>
      <div className="container-list">
        <h1>Filmes</h1>
        <div className="container-list-films">
          {films.length > 0 && films.map((film) => <CardFilm film={film} />)}
        </div>
      </div>
    </ScreenWrapper>
  );
}
