import { Header } from "../header/header.component";
import "./screen-wrapper.style.css";

export function ScreenWrapper({ children }) {
  return (
      <div className="screen-wrapper">
        <Header />
        {children}
      </div>
  );
}
