package com.lowes3.osp.service;

import com.lowes3.osp.dao.QuestionRepository;
import com.lowes3.osp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(Integer questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) return question.get();
        else return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        if(questionRepository.existsById(question.getQuestionId())) return questionRepository.save(question);
        else return null;
    }

    @Override
    public String deleteQuestionById(Integer questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()){
            questionRepository.deleteById(questionId);
            return "Deleted the question.";
        }
        else return "Could not find question by Id.";
    }
}
