package com.survey.survey_app.controller;

import com.survey.survey_app.entity.Question;
import com.survey.survey_app.entity.Response;
import com.survey.survey_app.entity.Survey;
import com.survey.survey_app.service.ResponseService;
import com.survey.survey_app.service.SurveyService;
import com.survey.survey_app.service.QuestionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ViewController {

	@Autowired
	private SurveyService surveyService;

	@Autowired
	private ResponseService responseService;

	@Autowired
	private QuestionService questionService;

    // Home Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Display Surveys
    @GetMapping("/surveys")
    public String showSurveys(Model model) {

        List<Survey> surveys = surveyService.getAllSurveys();

        model.addAttribute("surveys", surveys);

        return "surveys";
    }
    
    @GetMapping("/survey/{id}")
    public String takeSurvey(@PathVariable Long id, Model model) {

        Survey survey = surveyService.getSurveyById(id);

        model.addAttribute("survey", survey);

        return "take-survey";
    }
    
    @PostMapping("/submitSurvey")
    public String submitSurvey(
            @RequestParam("questionId") List<Long> questionIds,
            @RequestParam("answer") List<String> answers) {

        for (int i = 0; i < questionIds.size(); i++) {

            // FETCH QUESTION FROM DB
            Question question = questionService.getQuestionById(questionIds.get(i));

            // CREATE RESPONSE
            Response response = new Response();

            response.setAnswer(answers.get(i));
            response.setQuestion(question);

            // SAVE RESPONSE
            responseService.saveResponse(response);
        }

        return "redirect:/surveys";
    }
    
    @GetMapping("/admin/responses")
    public String viewResponses(Model model) {

        List<Response> responses = responseService.getAllResponses();

        model.addAttribute("responses", responses);

        return "responses";
    }
}