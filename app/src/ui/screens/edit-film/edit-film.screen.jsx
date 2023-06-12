import './edit-film.style.css';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { ScreenWrapper } from '../../components';
import { editFilm, getDetailFilm } from '../../../api';
import useGlobalFilm from '../../../context/films/film.context';
import { toast } from 'react-toastify';

export function EditFilmScreen() {
  const [films, setFilms] = useGlobalFilm();
  const [errorMessage, setErrorMessage] = useState('');
  const [film, setFilm] = useState({});
  const [formData, setFormData] = useState({});
  const { filmId } = useParams();

  useEffect(() => {
    async function fetchData() {
      const response = await getDetailFilm(filmId);
      setFilm(response);
      setFormData({
        title: response.title || '',
        description: response.description || '',
        category: response.category || '',
      });
    }

    fetchData();
  }, [filmId]);

  function handleChange(event) {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  }

  async function handleSubmit(event) {
    event.preventDefault();
    const validCategories = ['BRONZE', 'SILVER', 'GOLD'];
    if (!validCategories.includes(formData.category) && formData.category) {
      setErrorMessage('A categoria deve ser BRONZE, SILVER ou GOLD');
      return;
    }
    try {
      const updatedFilm = await editFilm(filmId, formData);
      const updatedFilms = films.map((film) =>
        film.id === filmId ? { ...film, ...updatedFilm } : film
      );
      setFilms(updatedFilms);
      setErrorMessage('');
      toast('Dados atualizados com sucesso.');
    } catch (error) {
      setErrorMessage(error.response.data.message);
    }
  }

  return (
    <ScreenWrapper>
      <form onSubmit={handleSubmit} className="container-form">
        <div>
          <label htmlFor="title">Título</label>
          <input
            type="text"
            id="title"
            name="title"
            value={formData.title || ''}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="description">Descrição</label>
          <input
            type="text"
            id="description"
            name="description"
            value={formData.description || ''}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="category">Categoria</label>
          <input
            type="text"
            id="category"
            name="category"
            value={formData.category || ''}
            onChange={handleChange}
          />
        </div>
        <div>
          <button type="submit" className="include-button">
            Atualizar filme
          </button>
        </div>
        {errorMessage && (
          <div>
            <p className="error-message">{errorMessage}</p>
          </div>
        )}
      </form>
    </ScreenWrapper>
  );
}
