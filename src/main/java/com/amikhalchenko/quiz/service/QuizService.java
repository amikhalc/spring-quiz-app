package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.entity.QuestionWrapper;
import com.amikhalchenko.quiz.entity.Quiz;
import com.amikhalchenko.quiz.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<Quiz> createQuiz(String category, int numQ, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> calculateResult(List<Response> responses);
}
