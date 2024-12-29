package service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    JavaQuestionServiceImpl javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<Question> get(int amount) {

        return null;
    }
}
