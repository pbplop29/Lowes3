package com.lowes3.osp.service;

import com.lowes3.osp.dao.SurveyRepository;
import com.lowes3.osp.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getSurveyById(Integer surveyId) {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if (survey.isPresent()) return survey.get();
        else return null;
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        if(surveyRepository.existsById(survey.getSurveyId())) return (Survey) surveyRepository.save(survey);
        else return null;
    }

    @Override
    public String deleteSurveyById(Integer surveyId) {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if (survey.isPresent()){
            surveyRepository.deleteById(surveyId);
            return "Deleted the Survey.";
        }
        else return "Could not find Survey by Id.";
    }
    
    @Override
    public List<Survey> getSurveys() {
        return (List<Survey>) surveyRepository.findAll();
    }
}
