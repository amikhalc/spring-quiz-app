package com.amikhalchenko.quiz.controller;

import com.amikhalchenko.quiz.entity.Quiz;
import com.amikhalchenko.quiz.service.QuizService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {

    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category,
                                           @RequestParam int numQ,
                                           @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }
}
