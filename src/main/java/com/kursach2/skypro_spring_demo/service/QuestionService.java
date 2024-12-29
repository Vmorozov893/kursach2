package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.HashSet;


public interface QuestionService {



    public Question addQuestion(String question, String answer);

    public Question findQuestion(Question question);

    public Question removeQuestion(Question question);

    public HashSet<Question> getSet();
}
