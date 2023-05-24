import React from "react";
import "../styles/About.css";
import leapLogo from "../assets/leap-logo.jpg";

const teamMembers = [
  {
    id: 1,
    name: "Antara Chakrabarti",
    email: "mailantara6@gmail.com",
    college: "Mody University of Science and Technology",
    emoji: "😃",
  },
  {
    id: 2,
    name: "Anushree Deshpande",
    email: "anushree.deshpande@cumminscollege.in",
    college: "CCOEW pune",
    emoji: "",
  },

  {
    id: 3,
    name: "Biplov Pokhrel",
    email: "biplov.nitrkl@gmail.com",
    college: "NIT Rourkela",
    emoji: "🐣",
  },

  {
    id: 4,
    name: "Chetna Ahir",
    email: "chetnaahir555@gmail.com",
    college: "Mody University of Science and Technology",
    emoji: "😠",
  },

  {
    id: 5,
    name: "Jaspriya Gujral",
    email: "jaspriya12@gmail.com",
    college: "Mody University of Science and Technology",
    emoji: "😆",
  },

  {
    id: 6,
    name: "Siddharth Das",
    email: "sdas200015@gmail.com",
    college: "NIT Silchar",
    emoji: "😴",
  },

  {
    id: 7,
    name: "Sudha Chintake",
    email: "sudha.chintake@cumminscollege.in",
    college: "CCOEW Pune",
    emoji: "😁",
  },

  {
    id: 8,
    name: "Utkarsh Mishra",
    email: "pranshuu17@gmail.com",
    college: "NIE Mysore",
    emoji: "🤓",
  },
  // Add more team members here...
];

const About = () => {
  return (
    <>
      <div className="about_description_container">
        <div className="about_us_title">About Us</div>
        <div className="description_and_logo">
          <img src={leapLogo} alt="Leap Logo" className="leap_logo" />
          <div className="description">
            The Lowe’s Engineering Acceleration Program (LEAP) seeks to disrupt
            and transform the digital landscape, thereby powering Lowe’s towards
            a new era. We have based LEAP on the concept of muscle memory.
            <br /> <br /> At LEAP, we believe that working on a new skill
            repeatedly in a conducive environment and applying it to real-world
            problems is the key to gain expertise on the skill. <br /> <br />{" "}
            LEAP enables the teams to come with their real-world problems for a
            period, get coached to acquire relevant skills in Product, Agile,
            DevOps, and Engineering domains. The team continues to deliver value
            while learning and improving skills.
          </div>
        </div>
      </div>

      <div className="team_members_container">
        <div className="about_us_title">The Team</div>
        <div className="team_members">
          {teamMembers.map((member) => (
            <div className="member_card" key={member.id}>
              <div style={{ "font-size": "20px", "font-weight": "bolder" }}>
                {member.name}
              </div>{" "}
              <div className="member_emoji">{member.emoji}</div>
              {member.role} <br />
              {member.email} <br />
              {member.college}
            </div>
          ))}
        </div>
      </div>
      <div className="task_description_container">
        <div className="about_us_title">The Task</div>
        <p> Post training assesment to test the learnings of the trainees.</p>
        <h3> Front-end:</h3>
        <ul>
          <li>HTML, CSS, and JavaScript for building user interfaces</li>
          <li>
            JavaScript frameworks such as React for building web applications
          </li>
        </ul>
        <h3> Back-end:</h3>
        <ul>
          <li>Programming language Java</li>
          <li>Spring Boot and spring framework</li>
          <li>H2 Database</li>
          <li>RESTful API design</li>
          <li>Server-side rendering</li>
        </ul>
      </div>
    </>
  );
};

export default About;
