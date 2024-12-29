package service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService{
    Set<Question> set = new HashSet<>();

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


}
