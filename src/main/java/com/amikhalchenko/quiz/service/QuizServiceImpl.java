package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.dao.QuestionDao;
import com.amikhalchenko.quiz.dao.QuizDao;
import com.amikhalchenko.quiz.entity.Question;
import com.amikhalchenko.quiz.entity.QuestionWrapper;
import com.amikhalchenko.quiz.entity.Quiz;
import com.amikhalchenko.quiz.entity.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{

    QuizDao quizDao;
    QuestionDao questionDao;

    @Override
    public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {
        List<Question> questions;

        if("all".equalsIgnoreCase(category)){
            questions = questionDao.findRandomQuestions(numQ);
        } else {
            questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Quiz savedQuiz = quizDao.save(quiz);

        return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        if (quiz.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q: questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        Integer score = 0;
        for (Response response: responses){
            if( response.getUserResponse().equalsIgnoreCase(questionDao.findById(response.getId()).get().getCorrectAnswer())) score++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);

    }
}
