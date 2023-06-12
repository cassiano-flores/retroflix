import createGlobalState from 'react-create-global-state';
import { FILM_KEY } from '../../constants/index';

const stateInStorage = localStorage.getItem(FILM_KEY);
const initialState = stateInStorage ? JSON.parse(stateInStorage) : [];
const [_useGlobalFilm, Provider] = createGlobalState(initialState);

function useGlobalFilm() {
  const [_film, _setFilm] = _useGlobalFilm();

  function setFilm(film) {
    localStorage.setItem(FILM_KEY, JSON.stringify(film));
    _setFilm(film);
  }

  return [_film, setFilm];
}

export const GlobalFilmProvider = Provider;
export default useGlobalFilm;
