import React from "react";
import "../styles/About.css";
import example from "../assets/leap-logo.jpg";

const teamMembers = [
  {
    id: 1,
    name: "Antara Chakrabarti",
    email: "mailantara6@gmail.com",
    college: "Mody University of Science and Technology",
  },
  {
    id: 2,
    name: "Anushree Deshpande",
    email: "anushree.deshpande@cumminscollege.in",
    college: "CCOEW pune",
  },

  {
    id: 3,
    name: "Biplov",
    email: "biplov.nitrkl@gmail.com",
    college: "NIT Rourkela",
  },

  {
    id: 4,
    name: "Chetna",
    email: "chetnaahir555@gmail.com",
    college: "Mody University of Science and Technology",
  },

  {
    id: 5,
    name: "Jaspriya Gujral",
    email: "jaspriya12@gmail.com",
    college: "Mody University of Science and Technology",
  },

  {
    id: 6,
    name: "Siddharth Das",
    email: "sdas200015@gmail.com",
    college: "NIT Silchar",
  },

  {
    id: 7,
    name: "Sudha Chintake",
    email: "sudha.chintake@cumminscollege.in",
    college: "CCOEW Pune",
  },

  {
    id: 8,
    name: "Utkarsh Mishra",
    email: "pranshuu17@gmail.com",
    college: "NIE Mysore",
  },
  // Add more team members here...
];

const About = () => {
  return (
    <div className="about">
      <h2>About Us</h2>
      <div className="container">
        <img src={example} alt="Example" className="image" />
        <text className="text">
          Lowe’s Engineering Accelerator Program The Lowe’s Engineering
          Acceleration Program (LEAP) seeks to disrupt and transform the digital
          landscape, thereby powering Lowe’s towards a new era. We have based
          LEAP on the concept of muscle memory. At LEAP, we believe that working
          on a new skill repeatedly in a conducive environment and applying it
          to real-world problems is the key to gain expertise on the skill. LEAP
          enables the teams to come with their real-world problems for a period,
          get coached to acquire relevant skills in Product, Agile, DevOps, and
          Engineering domains. The team continues to deliver value while
          learning and improving skills.
        </text>
      </div>

      <h2>Team</h2>
      <div className="team-members">
        {teamMembers.map((member) => (
          <div className="member-card" key={member.id}>
            <h3>{member.name}</h3>
            <p>{member.role}</p>
            <p>Email: {member.email}</p>
            <p>College: {member.college}</p>
            <p></p>
          </div>
        ))}
      </div>

      <div className="Usecase-3">
        {" "}
        <h2>Task : Usecase-3</h2>{" "}
        <p> Post training assesment to test the learnings of the trainees.</p>
        <h4> Front-end:</h4>
        <ul>
          <li>HTML, CSS, and JavaScript for building user interfaces</li>
          <li>
            JavaScript frameworks such as React for building web applications
          </li>
        </ul>
        <h4> Back-end:</h4>
        <ul>
          <li>Programming language Java</li>
          <li>Spring Boot and spring framework</li>
          <li>H2 Database</li>
          <li>RESTful API design</li>
          <li>Server-side rendering</li>
        </ul>
      </div>
    </div>
  );
};

export default About;
