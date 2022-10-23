package com.example.coursework2.number2.Controller;

import com.example.coursework2.number2.Service.Question;
import com.example.coursework2.number2.Service.QuestionServiceImpl;
import com.example.coursework2.number2.Service.QuestionServiceInterf;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class QuestionController {
    private final QuestionServiceImpl questionService;


    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String hello() {
        return "privet";
    }

    @GetMapping(path = "/java")
    public Collection<Question> allQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
       return questionService.addQuestion(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
        return questionService.removeQuestion(question, answer);
    }
}


