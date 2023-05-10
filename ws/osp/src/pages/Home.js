import React from "react";
import "../styles/Pages.css";

const Home = () => {
  return (
    <div>
      <span className="home-welcome">Welcome,</span>
      <br />
      <span className="home-welcome-follow">
        to our online survey portal, where you can create and participate in
        surveys from anywhere, at any time.
      </span>
      <br />
      <br />
      <div className="home-button">
        <button>Create a Survey</button>
      </div>
    </div>
  );
};

export default Home;
