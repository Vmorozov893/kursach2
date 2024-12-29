package service;

import com.kursach2.skypro_spring_demo.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ExaminerService {
    public Set<Question> get(int amount);
}
