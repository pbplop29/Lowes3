import React, { useEffect, useState } from "react";
import axios from "axios";

const RespondToSurvey = () => {
  const [surveys, setSurveys] = useState([]);
  const [selectedSurveyID, setSelectedSurveyID] = useState(null);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/getSurveys")
      .then((response) => {
        const data = response.data;
        setSurveys(data);
        if (!selectedSurveyID && data.length > 0) {
          setSelectedSurveyID(data ? data[0].surveyId : null);
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }, []);

  useEffect(() => {
    if (selectedSurveyID) {
      axios
        .get(`http://localhost:8080/getSurvey/${selectedSurveyID}`)
        .then((response) => {
          const data = response.data;
          setTitle(data.surveyTitle);
          setDescription(data.surveyDescription);
          setQuestions(data.questions);
          setAnswers(Array(data.questions.length).fill(""));
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    }
  }, [selectedSurveyID]);

  const handleAnswerChange = (event, index) => {
    const updatedAnswers = [...answers];
    updatedAnswers[index] = event.target.value;
    setAnswers(updatedAnswers);
  };

  const saveResponses = (surveyResponses) => {
    axios
      .post("http://localhost:8080/saveResponse", surveyResponses)
      .then((response) => {
        console.log("Responses saved successfully!");
        setAnswers(Array(questions.length).fill(""));
      })
      .catch((error) => {
        console.error("Error saving Responses:", error);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    const responsesWithQuestionId = questions.map((question, index) => {
      return {
        responseDetails: answers[index],
        question: {
          questionId: question.questionId,
        },
        user: {
          userId: 1,
        },
      };
    });
    console.log(JSON.stringify(responsesWithQuestionId));
    saveResponses(responsesWithQuestionId);
  };

  const questionInputs = questions.map((question, index) => (
    <div key={index} className="survey-questions">
      <label htmlFor={`question-${index}`}>{question.questionId}</label>
      &nbsp;
      <label htmlFor={`question-${index}`}>
        {question.questionDescription}
      </label>
      <input
        placeholder="Enter Answer Here"
        id={`question-${index}`}
        type="text"
        onChange={(event) => handleAnswerChange(event, index)}
        required
        style={{ color: "black" }}
        value={answers[index] || ""}
      />
    </div>
  ));

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="surveyNames">Choose survey to Respond</label>
      <select
        id="surveyNames"
        value={selectedSurveyID}
        onChange={(event) => setSelectedSurveyID(event.target.value)}
        required
        style={{ color: "black" }}
      >
        {surveys.map((survey) => (
          <option value={survey.surveyId}>{survey.surveyTitle}</option>
        ))}
      </select>

      {selectedSurveyID && (
        <>
          <label htmlFor="title">{title}</label>
          <label htmlFor="description">{description}</label>

          <div className="survey-questions-list">{questionInputs}</div>

          <input
            className="create-survey-form-button"
            type="submit"
            value="Submit Response"
            style={{ color: "black", width: "30%" }}
          />
        </>
      )}
    </form>
  );
};

export default RespondToSurvey;
