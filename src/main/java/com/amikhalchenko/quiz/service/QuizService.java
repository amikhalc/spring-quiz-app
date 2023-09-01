package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.entity.Quiz;
import org.springframework.http.ResponseEntity;

public interface QuizService {
    ResponseEntity<Quiz> createQuiz(String category, int numQ, String title);

}
