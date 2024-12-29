package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.HashSet;


public interface ExaminerService {
    public HashSet<Question> getQuestions(Integer amount);

}
