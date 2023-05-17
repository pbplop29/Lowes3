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

    const questionsWithDescription = questions.map((question) => {
      return {
        questionType: "Descriptive",
        questionDescription: question,
      };
    });

    const survey = {
      surveyTitle: title,
      surveyDescription: description,
      questions: questionsWithDescription,
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
        type="text"
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
        type="button"
        className="create-survey-form-button"
        onClick={handleAddQuestion}
        style={{ color: "black", width: "20%" }}
      >
        Add Question
      </button>
      <input
        className="create-survey-form-button"
        type="submit"
        value="Submit"
        style={{ color: "black", width: "20%" }}
      />
    </form>
  );
};

export default CreateSurvey;
