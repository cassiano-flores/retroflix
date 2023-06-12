import './film-detail.style.css';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { getDetailFilm } from '../../../api';
import { ScreenWrapper } from '../../components';

export function FilmDetailScreen() {
  const [film, setFilm] = useState({});
  const { filmId } = useParams();

  useEffect(() => {
    async function fetchData() {
      const response = await getDetailFilm(filmId);
      setFilm(response);
    }

    fetchData();
  }, [filmId]);

  return (
    <ScreenWrapper>
      <div className="container-film-detail">
        {Object.keys(film).length !== 0 &&
          Object.entries(film).map(
            ([key, value]) =>
              value !== null && (
                <div key={key} style={{ borderBottom: '1px solid gray' }}>
                  <div>
                    {key}:{' '}
                    {key === 'available'
                      ? value
                        ? 'yes'
                        : 'no'
                      : value}
                  </div>
                </div>
              )
          )}
      </div>
    </ScreenWrapper>
  );
}
