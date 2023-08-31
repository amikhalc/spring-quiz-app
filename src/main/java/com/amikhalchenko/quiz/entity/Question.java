package com.amikhalchenko.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table()
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String difficultyLevel;

}
