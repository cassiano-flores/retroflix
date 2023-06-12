import { axiosInstance } from '../_base/axios-instance';

export async function getListFilms() {
  const response = await axiosInstance.get(`/filmes`);

  return response.data;
}
