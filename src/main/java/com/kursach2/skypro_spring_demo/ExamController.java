package com.kursach2.skypro_spring_demo;

import com.kursach2.skypro_spring_demo.service.ExaminerService;
import com.kursach2.skypro_spring_demo.service.JavaQuestionServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.kursach2.skypro_spring_demo.service.ExaminerServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "get/{amount}")
    public String get(@PathVariable Integer amount){
        if(examinerService.get(amount)!=null) {
            return examinerService.get(amount).toString();
        }else{
            throw new RuntimeException("Ошибка!!!");
        }
    }

}
