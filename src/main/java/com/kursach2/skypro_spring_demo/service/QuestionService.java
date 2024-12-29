package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;


public interface QuestionService {
    public Question addQuestion(Question question);

    public Question findQuestion(Question question);

    public Question removeQuestion(Question question);

}
