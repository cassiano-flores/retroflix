import { axiosInstance } from '../_base/axios-instance';

export async function getDetailFilm( filmId ) {
  const response = await axiosInstance.get(`/filmes/${filmId}`);

  return response.data;
}
