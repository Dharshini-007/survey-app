package com.survey.survey_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    // MANY QUESTIONS BELONG TO ONE SURVEY
    @ManyToOne
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    private Survey survey;

    // ONE QUESTION CAN HAVE MANY RESPONSES
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Response> responses;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Setter for questionText
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Getter for survey
    public Survey getSurvey() {
        return survey;
    }

    // Setter for survey
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    // Getter for responses
    public List<Response> getResponses() {
        return responses;
    }

    // Setter for responses
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}