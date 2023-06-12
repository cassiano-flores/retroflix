import './include-film.style.css';
import { useState } from 'react';
import { ScreenWrapper } from '../../components';
import { includeFilm } from '../../../api';
import useGlobalFilm from '../../../context/films/film.context';
import { toast } from 'react-toastify';

export function IncludeFilmScreen() {
  const [films, setFilms] = useGlobalFilm();
  const [errorMessage, setErrorMessage] = useState('');

  const [formData, setFormData] = useState({
    title: '',
    description: '',
    category: '',
  });

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const validCategories = ['BRONZE', 'SILVER', 'GOLD'];
    if (!validCategories.includes(formData.category)) {
      setErrorMessage('A categoria deve ser BRONZE, SILVER ou GOLD');
      return;
    }
    try {
      const newFilm = await includeFilm(formData);
      setFilms([...films, newFilm]);
      setFormData({
        title: '',
        description: '',
        category: '',
      });
      setErrorMessage('');
      toast('Filme incluído com sucesso.');
    } catch (error) {
      setErrorMessage(error.response.data.message);
    }
  };

  return (
    <ScreenWrapper>
      <form onSubmit={handleSubmit} className="container-form">
        <div>
          <label htmlFor="title">Título</label>
          <input
            type="text"
            id="title"
            name="title"
            value={formData.title}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="description">Descrição</label>
          <input
            type="text"
            id="description"
            name="description"
            value={formData.description}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="category">Categoria</label>
          <input
            type="text"
            id="category"
            name="category"
            value={formData.category}
            onChange={handleChange}
          />
        </div>
        {errorMessage && <div className="error-message">{errorMessage}</div>}
        <button type="submit" className="include-button">
          Adicionar filme
        </button>
      </form>
    </ScreenWrapper>
  );
}
