package com.lowes3.osp.service;

import com.lowes3.osp.entity.Survey;
import org.springframework.stereotype.Service;

@Service
public interface SurveyService {
    public Survey saveSurvey(Survey survey);
    public Survey getSurveyById(Integer surveyId);
    public Survey updateSurvey(Survey survey);
    public String deleteSurveyById(Integer surveyId);


}
