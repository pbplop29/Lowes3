package com.lowes3.osp.controller;

import com.lowes3.osp.entity.Survey;
import com.lowes3.osp.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    //http://localhost:8080/saveSurvey
    @PostMapping("/saveSurvey")
    public Survey saveSurvey(@RequestBody Survey survey) {
        Survey survey1 = surveyService.saveSurvey(survey);
        return survey1;
    }

    //http://localhost:8080/getSurvey/1
    @GetMapping("/getSurvey/{surveyId}")
    public Survey getSurveyById(@PathVariable("surveyId") Integer surveyId) {
        return surveyService.getSurveyById(surveyId);
    }

    //http://localhost:8080/updateSurvey
    @PutMapping("/updateSurvey")
    public Survey updateSurvey(@RequestBody Survey survey){
        return surveyService.updateSurvey(survey);
    }

    //http://localhost:8080/deleteSurvey/1
    @GetMapping("/deleteSurvey")
    public String deleteSurveyByID(@PathVariable("surveyId") Integer surveyId){
        String checkIfDeleted = surveyService.deleteSurveyById(surveyId);
        return checkIfDeleted;
    }
}
