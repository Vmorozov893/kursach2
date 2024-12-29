package com.kursach2.skypro_spring_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kursach2.skypro_spring_demo.service.ExaminerServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
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
