package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    ResponseEntity<List<Question>> getAllQuestions();

    ResponseEntity<List<Question>> getQuestionsByCategory(String category);

    ResponseEntity<Question> addQuestion(Question question);
}
