import './header.style.css';
import logo from '../../../assets/img/logo-oldflix.png';
import back_icon from '../../../assets/img/back-icon.png';
import { Link, NavLink, useNavigate } from 'react-router-dom';
import { MENU_LIST } from '../../../constants';

export function Header() {

  return (
    <header className="container-header">
      <Link to={-1}>
        <img src={back_icon} alt="back-icon" />
      </Link>

      {MENU_LIST?.map((menuItem, key) => (
        <NavLink key={key} to={menuItem.pathTo}>
          {menuItem.title}
        </NavLink>
      ))}

      <Link to="/">
        <img src={logo} alt="logo-oldflix" />
      </Link>
    </header>
  );
}
