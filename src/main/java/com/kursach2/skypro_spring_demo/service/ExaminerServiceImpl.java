package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import com.kursach2.skypro_spring_demo.exception.BadRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionServices questionServices;


    public ExaminerServiceImpl(QuestionServices questionServices) {
        this.questionServices = questionServices;
    }


    public HashSet<Question> getQuestions(Integer amount) {
        if(questionServices.getMap().size()<amount){
            throw new BadRequest("Вопросов слишком мало!");
        }else if (amount<1) {
            throw new BadRequest("Кол-во вопросов должно быть натуральным числом!");
        }
        HashSet<Question> setResult = new HashSet<>();
        while(setResult.size()<amount){
            setResult.add(questionServices.getRandomQuestion());
        }
        return setResult;
    }

}
