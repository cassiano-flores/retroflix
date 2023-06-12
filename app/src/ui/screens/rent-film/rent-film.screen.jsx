import './rent-film.style.css';
import { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { rentFilm } from '../../../api/put/rent-film';
import useGlobalFilm from '../../../context/films/film.context';
import { ScreenWrapper } from '../../components';
import { toast } from 'react-toastify';

export function RentFilmScreen() {
  const { filmId } = useParams();
  const [films, setFilms] = useGlobalFilm();
  const [responsible, setResponsible] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    const updatedFilm = await rentFilm({ filmId, responsible });
    const updatedFilms = films.map((film) => {
      if (film.id === filmId) {
        return { ...film, responsible: updatedFilm.responsible };
      }
      return film;
    });

    setFilms(updatedFilms);
    navigate('/filmes');
    toast('Filme alugado com sucesso.');
  };

  return (
    <ScreenWrapper>
      <form onSubmit={handleSubmit} className="container-rent">
        <label htmlFor="responsible">Responsável</label>
        <input
          type="text"
          id="responsible"
          value={responsible}
          onChange={(event) => setResponsible(event.target.value)}
        />
        <button type="submit" className="include-button">
          Alugar
        </button>
      </form>
    </ScreenWrapper>
  );
}
