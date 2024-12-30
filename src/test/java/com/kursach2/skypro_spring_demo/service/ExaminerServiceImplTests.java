package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import com.kursach2.skypro_spring_demo.exception.BadRequest;
import org.assertj.core.api.CollectionAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final HashMap<String,Question> questionsMap = new HashMap<>(){{
        put("С чего начинается нумерация массива?",new Question("С чего начинается нумерация массива?","С нуля."));
        put("Для чего нужно ключевое слово new?",new Question("Для чего нужно ключевое слово new?","Для создания новых объектов."));
        put("От какого класса наследуют все классы Java?",new Question("От какого класса наследуют все классы Java?","Object."));
    }};
    private final Question question = questionsMap.get("С чего начинается нумерация массива?");
    private final List<Question> listQuestions = questionsMap.values().stream().toList();

    @Test
    public void getQuestionsTest() {
    int amount = 1;
    HashSet<Question> expectedQuestion = new HashSet<>();
    expectedQuestion.add(new Question("С чего начинается нумерация массива?","С нуля."));


    Mockito.when(javaQuestionService.getMap()).thenReturn((List<Question>) listQuestions );
    Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn((Question) question );

    HashSet<Question> actualQuestion = examinerService.getQuestions(1);

    Assertions.assertEquals(expectedQuestion.toString(),actualQuestion.toString());
    }

    @Test
    public void getQuestionsTestWithExceptionOne() {
        int amount = 4;

        Mockito.when(javaQuestionService.getMap()).thenReturn((List<Question>) listQuestions );

        BadRequest thrown = Assertions.assertThrows(BadRequest.class, () -> {
            examinerService.getQuestions(amount);
        });

        Assertions.assertEquals("Вопросов слишком мало!", thrown.getMessage());
    }

    @Test
    public void getQuestionsTestWithExceptionTwo() {
        int amount = -1;

        Mockito.when(javaQuestionService.getMap()).thenReturn((List<Question>) listQuestions );

        BadRequest thrown = Assertions.assertThrows(BadRequest.class, () -> {
            examinerService.getQuestions(amount);
        });

        Assertions.assertEquals("Кол-во вопросов должно быть натуральным числом!", thrown.getMessage());
    }


}
