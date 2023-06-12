import './index.css';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { GlobalFilmProvider } from './context/films/film.context';

function App() {
  return (
    <div className="App">
      <GlobalFilmProvider>
        <ToastContainer toastStyle={{ backgroundColor: 'black' }} />
        <RouterProvider router={router} />
      </GlobalFilmProvider>
    </div>
  );
}

export default App;
