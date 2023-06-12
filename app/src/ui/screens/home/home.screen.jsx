import React from 'react';
import './home.style.css';
import { Link } from 'react-router-dom';
import logo from '../../../assets/img/logo-oldflix.png';

export function HomeScreen() {
  return (
    <div className="home-screen">
      <Link to="/filmes">
        <img src={logo} alt="oldflix-logo" className="home-screen-logo" />
      </Link>
    </div>
  );
}
