import React from "react";
import "../styles/Navbar.css";
import { NavLink } from "react-router-dom";
import logo from "../assets/logo.png";
const Navbar = () => {
  return (
    <div>
      <div className="header">
        <div className="header-left">
          <NavLink exact to="/">
            <span>H</span>ome
          </NavLink>
          <NavLink exact to="/about">
            <span>A</span>bout
          </NavLink>
        </div>
        <div className="header-right">
          <img src={logo} alt="" />
        </div>
      </div>
    </div>
  );
};

export default Navbar;
