package com.lowes3.osp.service;

import com.lowes3.osp.entity.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    public Question saveQuestion(Question question);
    public Question getQuestionById(Integer questionId);
    public Question updateQuestion(Question question);
    public String deleteQuestionById(Integer questionId);


}
