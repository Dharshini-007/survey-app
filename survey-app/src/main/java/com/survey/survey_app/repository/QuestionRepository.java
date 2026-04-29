package com.survey.survey_app.repository;

import com.survey.survey_app.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}