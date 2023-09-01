package com.amikhalchenko.quiz.dao;

import com.amikhalchenko.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
