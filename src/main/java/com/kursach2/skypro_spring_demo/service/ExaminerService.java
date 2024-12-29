package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public interface ExaminerService {
    public HashMap<String, Question> get(Integer amount);

}
