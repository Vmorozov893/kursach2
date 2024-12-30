package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.List;


public interface QuestionServices {

    public Question addQuestion(String question, String answer);

    public Question findQuestion(String question);

    public Question removeQuestion(String question, String answer);

    public Question getRandomQuestion();

    public List<Question> getMap();
}
