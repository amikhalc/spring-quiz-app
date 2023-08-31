package com.amikhalchenko.quiz.service;

import com.amikhalchenko.quiz.dao.QuestionDao;
import com.amikhalchenko.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
