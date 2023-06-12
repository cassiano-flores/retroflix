import { axiosInstance } from '../_base/axios-instance';

export async function giveBackFilm({ filmId }) {
  const response = await axiosInstance.put(`/filmes/${filmId}/devolver`, {});

  return response.data;
}
