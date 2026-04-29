package com.survey.survey_app.service;

import com.survey.survey_app.entity.Question;
import com.survey.survey_app.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }
}