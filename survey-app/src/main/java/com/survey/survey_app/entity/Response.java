package com.survey.survey_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for answer
    public String getAnswer() {
        return answer;
    }

    // Setter for answer
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Getter for question
    public Question getQuestion() {
        return question;
    }

    // Setter for question
    public void setQuestion(Question question) {
        this.question = question;
    }
}