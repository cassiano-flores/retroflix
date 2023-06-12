import { axiosInstance } from '../_base/axios-instance';

export async function rentFilm({ filmId, responsible }) {
  const response = await axiosInstance.put(`/filmes/${filmId}/alugar`, {
    responsible,
  });

  return response.data;
}
