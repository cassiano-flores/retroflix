import { axiosInstance } from '../_base/axios-instance';

export async function removeFilm({ filmId }) {
  return await axiosInstance.delete(`/filmes/${filmId}`);
}
