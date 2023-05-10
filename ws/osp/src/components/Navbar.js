import React from "react";
import "../styles/Navbar.css";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <div>
      <div className="header">
        <div className="header-left">
          <NavLink exact to="/">
            Home
          </NavLink>
          <NavLink exact to="/about">
            About
          </NavLink>
          <NavLink exact to="/createSurvey">
            Create
          </NavLink>
        </div>
        <div className="header-right">OSP</div>
      </div>
    </div>
  );
};

export default Navbar;
