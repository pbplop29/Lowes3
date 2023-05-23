import React from "react";
import "../styles/About.css";
import example from "../example.jpg";

const teamMembers = [
  {
    id: 1,
    name: 'Antara Chakrabarti',
    email: 'john.doe@example.com',
    college: ''
  },
  {
    id: 2,
    name: 'Anushree Deshpande',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 3,
    name: 'Biplov',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 4,
    name: 'Chetna',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 5,
    name: 'Jaspriya Gujral',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 6,
    name: 'Siddharth Das',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 7,
    name: 'Sudha Chintake',
    email: 'jane.smith@example.com',
    college: ''
  },

  {
    id: 8,
    name: 'Utkarsh Mishra',
    email: 'pranshuu17@gmail.com',
    college: 'NIE Mysore'
  },
  // Add more team members here...
];

const About = () => {
  return (

    <div className="about">
      <h2>About Us</h2>
      <div className="container">
      <img src={example} alt="Example" className="image" />
      <text className="text">Lowe’s Engineering Accelerator Program
The Lowe’s Engineering Acceleration Program (LEAP) seeks to disrupt and transform the digital landscape, thereby powering Lowe’s towards a new era. We have based LEAP on the concept of muscle memory. At LEAP, we believe that working on a new skill repeatedly in a conducive environment and applying it to real-world problems is the key to gain expertise on the skill. LEAP enables the teams to come with their real-world problems for a period, get coached to acquire relevant skills in Product, Agile, DevOps, and Engineering domains. The team continues to deliver value while learning and improving skills.</text>
</div>
      <div className="Usecase-3"> <p> Usecase-3 is the task for post training assesment to test the learnings of the trainees.
        </p> </div>
      <div className="team-members">
        {teamMembers.map(member => (
          <div className="member-card" key={member.id}>
            <h3>{member.name}</h3>
            <p>{member.role}</p>
            <p>Email: {member.email}</p>
            <p>College: {member.college}</p>
            <p></p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default About;
