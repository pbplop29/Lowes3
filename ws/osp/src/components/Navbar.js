import React from "react";
import "../styles/Navbar.css";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <div>
      <div className="header">
        <div className="header-left">
          <NavLink exact="true" to="/">
            Home
          </NavLink>
          <NavLink exact="true" to="/about">
            About
          </NavLink>
          <NavLink exact="true" to="/createSurvey">
            Create
          </NavLink>
        </div>
        <div className="header-right">OSP</div>
      </div>
    </div>
  );
};

export default Navbar;
