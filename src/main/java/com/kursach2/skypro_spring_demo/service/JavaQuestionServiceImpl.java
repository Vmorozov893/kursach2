package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class JavaQuestionServiceImpl implements QuestionService{
    HashSet<Question> set = new HashSet<>();

    public Question addQuestion(String question, String answer){
        Question question1= new Question(question,answer);
        set.add(question1);
        return question1;
    }

    public Question findQuestion(String question, String answer){
        Question question1= new Question(question,answer);
        if(!set.contains(question1)){
            throw new RuntimeException("Вопрос не найден");
        }
        return question1;
    }

    public Question removeQuestion(String question, String answer){
        Question question1= new Question(question,answer);
        if(!set.contains(question1)){
            throw new RuntimeException("Вопрос не найден");
        }
        set.remove(question1);
        return question1;
    }

    public HashSet<Question> getSet(){
        return set;
    }


}
