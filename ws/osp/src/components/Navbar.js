import React from "react";
import "../styles/Navbar.css";
import { NavLink } from "react-router-dom";
const Navbar = () => {
  return (
    <div>
      <div className="header">
        <NavLink
          to="/"
          exact
          activeStyle={{ fontweight: "bold", color: "red" }}
        >
          <span>H</span>ome
        </NavLink>
        <NavLink
          to="/about"
          exact
          activeStyle={{ fontweight: "bold", color: "red" }}
        >
          <span>A</span>bout
        </NavLink>
      </div>
    </div>
  );
};

export default Navbar;
