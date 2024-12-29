package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    JavaQuestionServiceImpl javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public HashSet<Question> get(Integer amount) {
        if(javaQuestionService.getSet().size()<amount){
            throw new RuntimeException("Столько вопросов нет");
        }
        HashSet<Question> set1 = new HashSet<>();
        for(Question question: javaQuestionService.getSet()){
            if(set1.size()<=amount){
                set1.add(question);
            }
        }
        return set1;
    }

}
