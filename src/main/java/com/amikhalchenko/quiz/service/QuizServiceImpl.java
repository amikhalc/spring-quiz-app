package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.dao.QuestionDao;
import com.amikhalchenko.quiz.dao.QuizDao;
import com.amikhalchenko.quiz.entity.Question;
import com.amikhalchenko.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{

    QuizDao quizDao;
    QuestionDao questionDao;

    @Override
    public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }
}
