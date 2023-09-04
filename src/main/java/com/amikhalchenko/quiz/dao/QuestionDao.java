package com.amikhalchenko.quiz.dao;


import com.amikhalchenko.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

        List<Question> findByCategory(String category);

        @Query(value = "SELECT * FROM question q ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
        List<Question> findRandomQuestions(int numQ);

        @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
        List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
