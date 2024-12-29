package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionServices {
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

    public Question getRandomQuestion(){
        Random random = new Random();
        int randomNumber = random.nextInt(this.map.size());
        List<Question> listOfQuestion = this.map.values().stream().toList();
        return listOfQuestion.get(randomNumber);
    }

    public List<Question> getMap() {
        return this.map.values().stream().toList();
    }

    public void addedQuestions(){
        this.map.put("С чего начинается нумерация массива?",new Question("С чего начинается нумерация массива?","С нуля."));
        this.map.put("Для чего нужно ключевое слово new?",new Question("Для чего нужно ключевое слово new?","Для создания новых объектов."));
        this.map.put("От какого класса наследуют все классы Java?",new Question("От какого класса наследуют все классы Java?","Object."));
        this.map.put("Сколько параметров может принимать функция?",new Question("Сколько параметров может принимать функция?","Неограниченное количество."));
        this.map.put("Каждый файл должен называется...",new Question("Каждый файл должен называется...","по имени класса в нём."));
        this.map.put("Что общего у всех элементов массива?",new Question("Что общего у всех элементов массива?","Их тип данных."));
    }



}
