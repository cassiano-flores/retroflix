import { axiosInstance } from '../_base/axios-instance';

export async function editFilm( filmId, { title, description, category }) {
  const response = await axiosInstance.put(`/filmes/${filmId}`, {
    title,
    description,
    category,
  });

  return response.data;
}
