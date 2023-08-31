package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(String category);
}
