import { createBrowserRouter } from "react-router-dom";
import {
  HomeScreen,
  FilmsListScreen,
  FilmDetailScreen,
  EditFilmScreen,
  IncludeFilmScreen,
  RentFilmScreen
} from "../ui/screens";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <HomeScreen />,
  },
  {
    path: "/filmes",
    element: <FilmsListScreen />,
  },
  {
    path: "/filmes/:filmId",
    element: <FilmDetailScreen />,
  },
  {
    path: "/filmes/:filmId/editar",
    element: <EditFilmScreen />,
  },
  {
    path: "/filmes/adicionar",
    element: <IncludeFilmScreen />,
  },
  {
    path: "/filmes/:filmId/alugar",
    element: <RentFilmScreen />,
  }
]);
