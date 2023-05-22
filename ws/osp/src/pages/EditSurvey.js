import React, { useEffect } from "react";
import { useState } from "react";
import "../styles/CreateSurvey.css";
import axios from "axios";

const EditSurvey = () => {

  const [surveys, updateSurveys] = useState([]);
  const [selectedSurveyID, updateSelectedSurveyID] = useState(null)
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [questions, setQuestions] = useState([""]);
  const [currentIndex,updateCurrentIndex]=useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/getSurveys')
      .then(response => {
        const data = response.data;
        updateSurveys(data);
        if (!selectedSurveyID)
          updateSelectedSurveyID(data ? data[0].surveyId : null)
      })
      .catch(error => {
        console.error('Error:', error);
      });
  },[])

  useEffect(() => {
    if (selectedSurveyID)
      axios.get(`http://localhost:8080/getSurvey/${selectedSurveyID}`)
        .then(response => {
          const data = response.data;
          setTitle(data.surveyTitle)
          setDescription(data.surveyDescription)
          setQuestions(data.questions)
          updateCurrentIndex(data ? data.questions[data.questions.length-1].questionId+1 : null)

        })
        .catch(error => {
          console.error('Error:', error);
        });
  }, [selectedSurveyID])



  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleDescriptionChange = (event) => {
    setDescription(event.target.value);
  };

  const handleQuestionChange = (event, index) => {
    const newQuestions = [...questions];
    newQuestions[index].questionDescription = event.target.value;
    setQuestions(newQuestions);
  };

  const handleAddQuestion = () => {
    const newQuestions = [...questions, {questionType: "Descriptive",
      questionDescription: "",questionId:currentIndex}];
      updateCurrentIndex(currentIndex+1);
    setQuestions(newQuestions);
  };

  const handleRemoveQuestion = (index) => {
    const newQuestions = [...questions];
    newQuestions.splice(index, 1);
    setQuestions(newQuestions);
  };

  const updateSurvey = (survey) => {
    
    axios
    .put("http://localhost:8080/updateSurvey", survey)
      .then((response) => {
        console.log("Survey updated successfully!");
      })
      .catch((error) => {
        console.error("Error updating survey:", error);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const questionsWithDescription = questions.map((question,index) => {
      return {
        questionId:question.questionId,
        questionType: question.questionType,
        questionDescription: question.questionDescription,
        responses: question.responses || [],
      
      };
    });

    const survey = {
      surveyId: selectedSurveyID,
      surveyTitle: title,
      surveyDescription: description,
      questions: questionsWithDescription,
    };

    updateSurvey(survey);
  };

  const questionInputs = questions.map((question, index) => (
    <div key={index} className="survey-questions">
      <label htmlFor={`question-${index}`}>{`${index + 1}`}</label>
      <input
        placeholder="Enter Question Here"
        id={`question-${index}`}
        type="text"
        value={question.questionDescription}
        onChange={(event) => handleQuestionChange(event, index)}
        required
        style={{ color: "black" }}
      />
      {(
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

      <label htmlFor="surveyNames">Choose survey to edit</label>
      <select
        id="surveyNames"
        value={selectedSurveyID ? surveys.find((survey) => survey.surveyId === selectedSurveyID)?.surveyTitle : null}
        onChange={(event) => {

          updateSelectedSurveyID(event.target.value)
        }}
        required
        style={{ color: "black" }}
      >
        {surveys.map((survey) => <option value={survey.surveyId}>{survey.surveyTitle}</option>)}

      </select>


      {
        selectedSurveyID && <>
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
            value="Update"
            style={{ color: "black", width: "20%" }}
          />
        </>
      }

    </form>
  );
};

export default EditSurvey;
