import React from "react";
import "../styles/Pages.css";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="home">
      <span className="home-welcome">Welcome,</span>
      <br />
      <span className="home-welcome-follow">
        to our online survey portal, where you can create and participate in
        surveys from anywhere, at any time.
      </span>
      <br />
      <br />
      <div className="home-welcome-description">
        Are you looking to gather insights on a particular topic or simply want
        to conduct a survey for your research? <br />
        <span>Look no further!</span>
        <br /> Our online survey portal provides you with an easy-to-use
        platform to create, customize, and distribute surveys to your target
        audience.
        <br />
        <br />
        Let's try creating a survey below.
      </div>
      <div className="home-button">
        <button>
          <Link to="/createSurvey" className="home-button-link">
            {" "}
            Create a Survey
          </Link>
        </button>
      </div>
    </div>
  );
};

export default Home;
