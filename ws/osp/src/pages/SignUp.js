import { useState } from "react";
import React from "react";
import axios from "axios";

const SignUp = () => {
  const [userName, setUserName] = useState("");
  const [userEmailAddress, setuserEmailAddress] = useState("");
  const [userPassword, setuserPassword] = useState("");

  const handleUserNameChange = (event) => {
    setUserName(event.target.value);
  };
  const handleUserEmailAddressChange = (event) => {
    setuserEmailAddress(event.target.value);
  };
  const handleUserPasswordChange = (event) => {
    setuserPassword(event.target.value);
  };

  const saveUser = (user) => {
    axios
      .post("http://localhost:8080/saveUser", user)
      .then((response) => {
        console.log("User saved successfully!");
      })
      .catch((error) => {
        console.error("Error saving User:", error);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const user = {
      userEmailAddress: userEmailAddress,
      userName: userName,
      userPassword: userPassword,
    };
    saveUser(user);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="username">Email Address</label>
      <input
        placeholder="Enter Email Here"
        id="userEmailAddress"
        type="text"
        value={userEmailAddress}
        onChange={handleUserEmailAddressChange}
        required
        style={{ color: "black" }}
      />
      <label htmlFor="username">Username</label>
      <input
        placeholder="Enter Username Here"
        id="username"
        type="text"
        value={userName}
        onChange={handleUserNameChange}
        required
        style={{ color: "black" }}
      />
      <label htmlFor="username">Password</label>
      <input
        placeholder="Enter Password Here"
        id="userPassword"
        type="password"
        value={userPassword}
        onChange={handleUserPasswordChange}
        required
        style={{ color: "black" }}
      />
      <input
        className="create-survey-form-button"
        type="submit"
        value="Submit"
        style={{ color: "black", width: "20%" }}
      />
    </form>
  );
};

export default SignUp;
