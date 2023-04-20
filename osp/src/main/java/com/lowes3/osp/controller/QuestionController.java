package com.lowes3.osp.controller;

import com.lowes3.osp.entity.Question;
import com.lowes3.osp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //Create or save or add
    //http://localhost:8080/saveQuestion
    @PostMapping("/saveQuestion")
    public Question saveQuestion(@RequestBody Question question) {
        Question question1 = questionService.saveQuestion(question);
        return question1;
    }

    //http://localhost:8080/getQuestion/1
    @GetMapping("/getQuestion/{questionId}")
    public Question getQuestionById(@PathVariable("questionId") Integer questionId) {
        return questionService.getQuestionById(questionId);
    }

    //http://localhost:8080/updateQuestion
    @PutMapping("/updateQuestion")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    //http://localhost:8080/deleteQuestion/1
    @DeleteMapping("/deleteQuestion/{questionId}")
    public String deleteQuestionByID(@PathVariable("questionId") Integer questionId){
        String checkIfDeleted = questionService.deleteQuestionById(questionId);
        return checkIfDeleted;
    }
}
