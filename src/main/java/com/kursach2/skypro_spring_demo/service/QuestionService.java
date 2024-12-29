package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public interface QuestionService {

    public Question addQuestion(String question, String answer);

    public Question findQuestion(String question);

    public Question removeQuestion(String question, String answer);

    public Question getRandomQuestion();

    public void addedQuestions();

    public List<Question> getMap();
}
