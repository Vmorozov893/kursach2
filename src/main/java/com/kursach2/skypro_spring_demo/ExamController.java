package com.kursach2.skypro_spring_demo;

import com.kursach2.skypro_spring_demo.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "get/{amount}")
    public String get(@PathVariable Integer amount){
            return examinerService.getQuestions(amount).toString();
    }

}
