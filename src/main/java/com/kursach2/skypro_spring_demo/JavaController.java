package com.kursach2.skypro_spring_demo;

import com.kursach2.skypro_spring_demo.service.QuestionServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exam/java")
public class JavaController {

    private final QuestionServices QuestionServices;

    public JavaController(QuestionServices QuestionServices) {
        this.QuestionServices = QuestionServices;
    }

    @GetMapping(path = "")
    public String getAll(){
        if(QuestionServices.getMap()!=null) {
            return QuestionServices.getMap().toString();
        }else{
            throw new RuntimeException("Ошибка!!!");
        }
    }

    @GetMapping(path = "add")
    public String add(@RequestParam(required = false) String question, @RequestParam(required = false) String answer){
        return QuestionServices.addQuestion(question,answer).toString();
    }

    @GetMapping(path = "find")
    public String find(@RequestParam(required = false) String question){
        return QuestionServices.findQuestion(question).toString();
    }

    @GetMapping(path = "remove")
    public String remove(@RequestParam(required = false) String question, @RequestParam(required = false) String answer){
        return QuestionServices.removeQuestion(question,answer).toString();
    }

}
