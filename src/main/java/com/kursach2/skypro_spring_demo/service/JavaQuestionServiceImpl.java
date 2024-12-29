package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    HashMap<String, Question> map = new HashMap<>();

    public Question addQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (this.map.get(question) != null) {
            throw new RuntimeException("Такой вопрос уже есть");
        }
        map.put(question, question1);
        return question1;
    }

    public Question findQuestion(String question) {
        if (this.map.get(question) == null) {
            throw new RuntimeException("Вопрос не найден");
        }
        return this.map.get(question);
    }

    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (this.map.get(question) == null) {
            throw new RuntimeException("Вопрос не найден");
        }
        if (!this.map.get(question).getAnswer().equals(answer)) {
            throw new RuntimeException("Ответы не совпадают");
        }
        this.map.remove(question);
        return question1;
    }

    public HashMap<String, Question> getMap() {
        return this.map;
    }


}
