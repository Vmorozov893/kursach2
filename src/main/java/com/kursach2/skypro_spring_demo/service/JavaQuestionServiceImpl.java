package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class JavaQuestionServiceImpl implements QuestionService{
    HashSet<Question> set = new HashSet<>();

    public Question addQuestion(Question question){
        set.add(question);
        return question;
    }

    public Question findQuestion(Question question){
        if(!set.contains(question)){
            throw new RuntimeException("Вопрос не найден");
        }
        return question;
    }

    public Question removeQuestion(Question question){
        if(!set.contains(question)){
            throw new RuntimeException("Вопрос не найден");
        }
        set.remove(question);
        return question;
    }

    public HashSet<Question> getSet(){
        return set;
    }


}
