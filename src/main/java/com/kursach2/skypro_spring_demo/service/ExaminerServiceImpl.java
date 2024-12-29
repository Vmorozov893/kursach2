package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    JavaQuestionServiceImpl javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public HashMap<String, Question> get(Integer amount) {
        if(javaQuestionService.getMap().size()<amount){
            throw new RuntimeException("Столько вопросов нет");
        }
        HashMap<String,Question> map1 = new HashMap<>();
        for(Question question: javaQuestionService.getMap()){
            if(map1.size()<=amount){
                map1.put(question.getQuestion(),question);
            }
        }
        return map1;
    }

}
