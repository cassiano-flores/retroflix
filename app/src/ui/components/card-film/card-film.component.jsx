import './card-film.style.css';
import { useNavigate } from 'react-router-dom';
import { removeFilm, giveBackFilm } from '../../../api';
import { CustomButton } from '../custom-button/custom-button.component';
import useGlobalFilm from '../../../context/films/film.context';
import { toast } from 'react-toastify';

export function CardFilm({ film }) {
  const navigate = useNavigate();
  const [films, setFilms] = useGlobalFilm();

  function handleEditButton() {
    navigate(`/filmes/${film.id}/editar`);
  }

  async function handleRemoveButton() {
    await removeFilm({ filmId: film.id });
    setFilms(films.filter((film) => film.id !== film.id));
    toast('Filme removido com sucesso.');
  }

  function handleDetailButton() {
    navigate(`/filmes/${film.id}`);
  }

  function handleRentButton() {
    navigate(`/filmes/${film.id}/alugar`);
  }

  async function handleGiveBackButton() {
    await giveBackFilm({ filmId: film.id });
    toast('Filme devolvido com sucesso.');
  }

  return (
    <div className="card-film">
      <div className="card-film-header">
        <CustomButton onClick={handleEditButton} textArea="Editar" />
        <span>{film.id}</span>
        <CustomButton onClick={handleRemoveButton} textArea="Remover" />
      </div>

      <div className="card-film-body">
        {film.title}
        <div className="card-film-description">{film.description}</div>
        {film.category}
      </div>

      <div className="card-film-footer">
        <CustomButton onClick={handleDetailButton} textArea="Detalhes" />

        {film.available ? (
          <CustomButton onClick={handleRentButton} textArea="Alugar" />
        ) : (
          <CustomButton onClick={handleGiveBackButton} textArea="Devolver" />
        )}
      </div>
    </div>
  );
}
