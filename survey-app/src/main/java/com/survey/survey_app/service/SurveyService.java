package com.survey.survey_app.service;

import com.survey.survey_app.entity.Question;
import com.survey.survey_app.entity.Survey;
import com.survey.survey_app.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey createSurvey(Survey survey) {
    	// Set survey for each question
        if (survey.getQuestions() != null) {
            for (Question q : survey.getQuestions()) {
                q.setSurvey(survey);
            }
        }
        return surveyRepository.save(survey);
    }
    
 // GET ALL SURVEYS
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // GET SURVEY BY ID
    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id).orElse(null);
    }

    // DELETE SURVEY
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}