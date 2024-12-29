package com.kursach2.skypro_spring_demo;

import com.kursach2.skypro_spring_demo.service.JavaQuestionServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.kursach2.skypro_spring_demo.service.ExaminerServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    private final JavaQuestionServiceImpl javaQuestionService;

    public ExamController(ExaminerServiceImpl examinerService, JavaQuestionServiceImpl javaQuestionService) {
        this.examinerService = examinerService;
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "get/{amount}")
    public String get(@PathVariable Integer amount){
        if(examinerService.get(amount)!=null) {
            return examinerService.get(amount).toString();
        }else{
            throw new RuntimeException("Ошибка!!!");
        }
    }

    @GetMapping(path = "java")
    public String getAll(){
        if(javaQuestionService.getSet()!=null) {
            return javaQuestionService.getSet().toString();
        }else{
            throw new RuntimeException("Ошибка!!!");
        }
    }

    @GetMapping(path = "java/add")
    public String add(@RequestParam(required = false) String question,@RequestParam(required = false) String answer){
        return javaQuestionService.addQuestion(question,answer).toString();
    }



}
