import React from "react";
import { useState } from "react";
import "../styles/CreateSurvey.css";

const CreateSurvey = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [questions, setQuestions] = useState([""]);

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleDescriptionChange = (event) => {
    setDescription(event.target.value);
  };

  const handleQuestionChange = (event, index) => {
    const newQuestions = [...questions];
    newQuestions[index] = event.target.value;
    setQuestions(newQuestions);
  };

  const handleAddQuestion = () => {
    const newQuestions = [...questions, ""];
    setQuestions(newQuestions);
  };

  const handleRemoveQuestion = (index) => {
    const newQuestions = [...questions];
    newQuestions.splice(index, 1);
    setQuestions(newQuestions);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    const survey = {
      title,
      description,
      questions,
    };

    console.log(JSON.stringify(survey));
  };

  const questionInputs = questions.map((question, index) => (
    <div key={index}>
      <label htmlFor={`question-${index}`}>{`Question ${index + 1}`}</label>
      <input
        id={`question-${index}`}
        type="text"
        value={question}
        onChange={(event) => handleQuestionChange(event, index)}
        required
        style={{ color: "black" }}
      />
      {index > 0 && (
        <button
          type="button"
          onClick={() => handleRemoveQuestion(index)}
          style={{ color: "black" }}
        >
          Remove
        </button>
      )}
    </div>
  ));

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="title">Title:</label>
      <input
        id="title"
        type="text"
        value={title}
        onChange={handleTitleChange}
        required
        style={{ color: "black" }}
      />

      <div>
        <label htmlFor="description">Description:</label>
        <input
          id="description"
          value={description}
          onChange={handleDescriptionChange}
          required
          style={{ color: "black" }}
        />
      </div>
      {questionInputs}
      <button
        type="button"
        onClick={handleAddQuestion}
        style={{ color: "black" }}
      >
        Add Question
      </button>
      <button type="submit" style={{ color: "black" }}>
        Submit
      </button>
    </form>
  );
};

export default CreateSurvey;
