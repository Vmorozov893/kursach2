package com.kursach2.skypro_spring_demo.service;

import com.kursach2.skypro_spring_demo.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


public class JavaQuestionServiceTests {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void clear() {
        javaQuestionService = new JavaQuestionService();
    }

    private void addQuestions(int count) {
        for (int i = 1; i <= count; i++) {
            javaQuestionService.addQuestion("question" + i, "answer" + i);
        }

    }

    @Test
    public void addQuestionTestOne() {
        Question question = new Question("С чего начинается нумерация массива?", "С нуля.");

        Question actualQuestion = javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());

        Assertions.assertEquals(question.toString(), actualQuestion.toString());
    }

    @Test
    public void addQuestionTestWithException() {
        Question question = new Question("С чего начинается нумерация массива?", "С нуля.");

        javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            javaQuestionService.addQuestion(question.getQuestion(), question.getAnswer());
        });

        Assertions.assertEquals("Такой вопрос уже есть", thrown.getMessage());
    }

    @Test
    public void findQuestionTestOne() {
        addQuestions(3);
        Question expectedQuestion = new Question("question" + 1, "answer" + 1);
        Question actualQuestion = javaQuestionService.findQuestion(expectedQuestion.getQuestion());

        Assertions.assertEquals(expectedQuestion.toString(), actualQuestion.toString());
    }

    @Test
    public void findQuestionTestTwo() {
        addQuestions(3);
        Question expectedQuestion = new Question("question" + 2, "answer" + 2);
        Question actualQuestion = javaQuestionService.findQuestion(expectedQuestion.getQuestion());

        Assertions.assertEquals(expectedQuestion.toString(), actualQuestion.toString());
    }

    @Test
    public void findQuestionTestWithExceptionOne() {
        addQuestions(3);
        Question expectedQuestion = new Question("question" + 4, "answer" + 4);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            javaQuestionService.findQuestion(expectedQuestion.getQuestion());
        });

        Assertions.assertEquals("Вопрос не найден", thrown.getMessage());
    }

    @Test
    public void removeQuestionTestOne() {
        addQuestions(2);

        Question expectedQuestion = new Question("question" + 1, "answer" + 1);

        Question actualQuestion = javaQuestionService.removeQuestion(expectedQuestion.getQuestion(),expectedQuestion.getAnswer());

        Assertions.assertEquals(expectedQuestion.toString(),actualQuestion.toString());
    }

    @Test
    public void removeQuestionTestTwo() {
        int count = 2;
        addQuestions(count);

        Question removedQuestion = new Question("question" + 2, "answer" + 2);
        List<Question> expectedListOfQuestions = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            expectedListOfQuestions.add(new Question( "question"+ i, "answer" + i));
        }
        expectedListOfQuestions.remove(1);

        javaQuestionService.removeQuestion(removedQuestion.getQuestion(),removedQuestion.getAnswer());



        Assertions.assertEquals(expectedListOfQuestions.toString(),javaQuestionService.getMap().toString());
    }

    @Test
    public void removeQuestionTestWithExceptionOne() {
        addQuestions(3);
        Question expectedQuestion = new Question("question" + 4, "answer" + 4);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            javaQuestionService.removeQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        });

        Assertions.assertEquals("Вопрос не найден", thrown.getMessage());
    }

    @Test
    public void removeQuestionTestWithExceptionTwo() {
        addQuestions(3);
        Question expectedQuestion = new Question("question" + 2, "answer" + 4);
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            javaQuestionService.removeQuestion(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        });

        Assertions.assertEquals("Ответы не совпадают", thrown.getMessage());
    }

    @Test
    public void getRandomQuestionTest(){
        addQuestions(3);
        Question actualQuestion = javaQuestionService.getRandomQuestion();

        Assertions.assertTrue(javaQuestionService.getMap().contains(actualQuestion));
    }


}
