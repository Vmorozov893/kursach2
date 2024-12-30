package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionServices {
    private final HashMap<String, Question> map = new HashMap<>();

    private final Random random = new Random();

    public Question addQuestion(String question, String answer) {
        Question questionWithAnswer = new Question(question, answer);
        if (map.containsKey(question)) {
            throw new RuntimeException("Такой вопрос уже есть");
        }
        map.put(question, questionWithAnswer);
        return questionWithAnswer;
    }

    public Question findQuestion(String question) {
        if (!map.containsKey(question)) {
            throw new RuntimeException("Вопрос не найден");
        }
        return map.get(question);
    }

    public Question removeQuestion(String question, String answer) {
        Question questionWithAnswer = new Question(question, answer);
        if (!map.containsKey(question)) {
            throw new RuntimeException("Вопрос не найден");
        }
        if (!map.get(question).getAnswer().equals(answer)) {
            throw new RuntimeException("Ответы не совпадают");
        }
        map.remove(question);
        return questionWithAnswer;
    }

    public Question getRandomQuestion(){
        int randomNumber = random.nextInt(map.size());
        List<Question> listOfQuestion = map.values().stream().toList();
        return listOfQuestion.get(randomNumber);
    }

    public List<Question> getMap() {
        return map.values().stream().toList();
    }

}
