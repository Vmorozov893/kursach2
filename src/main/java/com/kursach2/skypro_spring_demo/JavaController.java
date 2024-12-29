package com.kursach2.skypro_spring_demo;

import com.kursach2.skypro_spring_demo.service.JavaQuestionServiceImpl;
import com.kursach2.skypro_spring_demo.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exam/java")
public class JavaController {

    private final QuestionService javaQuestionService;

    public JavaController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "")
    public String getAll(){
        if(javaQuestionService.getMap()!=null) {
            return javaQuestionService.getMap().toString();
        }else{
            throw new RuntimeException("Ошибка!!!");
        }
    }

    @GetMapping(path = "add")
    public String add(@RequestParam(required = false) String question, @RequestParam(required = false) String answer){
        return javaQuestionService.addQuestion(question,answer).toString();
    }

    @GetMapping(path = "find")
    public String find(@RequestParam(required = false) String question){
        return javaQuestionService.findQuestion(question).toString();
    }

    @GetMapping(path = "remove")
    public String remove(@RequestParam(required = false) String question, @RequestParam(required = false) String answer){
        return javaQuestionService.removeQuestion(question,answer).toString();
    }

    @GetMapping(path = "added")
    public String added(){
        javaQuestionService.addedQuestions();
        return javaQuestionService.getMap().toString();
    }

}
