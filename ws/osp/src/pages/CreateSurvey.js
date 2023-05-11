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
    <div key={index} className="survey-questions">
      <label htmlFor={`question-${index}`}>{`${index + 1}`}</label>
      <input
        placeholder="Enter Question Here"
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
          Delete
        </button>
      )}
    </div>
  ));

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="title">Survey Title</label>
      <input
        placeholder="Enter Title Here"
        id="title"
        type="text"
        value={title}
        onChange={handleTitleChange}
        required
        style={{ color: "black" }}
      />
      <label htmlFor="description">Survey Description</label>
      <input
        placeholder="Enter Description Here"
        id="description"
        value={description}
        onChange={handleDescriptionChange}
        required
        style={{ color: "black" }}
      />
      Survey Questions:
      <div className="survey-questions-list">{questionInputs}</div>
      <button
        className="create-survey-form-button"
        type="button"
        onClick={handleAddQuestion}
        style={{ color: "black" }}
      >
        Add Question
      </button>
      <button
        type="submit"
        className="create-survey-form-button"
        style={{ color: "black" }}
      >
        Submit
      </button>
    </form>
  );
};

export default CreateSurvey;
