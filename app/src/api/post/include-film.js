import { axiosInstance } from '../_base/axios-instance';

export async function includeFilm({ title, description, category }) {
  const response = await axiosInstance.post('/filmes', {
    title,
    description,
    category,
  });

  return response.data;
}
