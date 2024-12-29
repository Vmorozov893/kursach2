package service;

import com.kursach2.skypro_spring_demo.Question;

import java.util.List;

public interface ExaminerService {
    public List<Question> get(int amount);
}
