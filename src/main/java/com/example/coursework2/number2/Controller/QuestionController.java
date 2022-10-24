package com.example.coursework2.number2.Controller;

import com.example.coursework2.number2.Service.Question;
import com.example.coursework2.number2.Service.QuestionServiceInterf;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class QuestionController {
    private final QuestionServiceInterf questionServiceInterf;

    public QuestionController(QuestionServiceInterf questionServiceInterf) {
        this.questionServiceInterf = questionServiceInterf;
    }


    @GetMapping
    public Collection<Question> allQuestions() {
        return questionServiceInterf.getAll();
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
       return questionServiceInterf.addQuestion(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
        return questionServiceInterf.removeQuestion(question, answer);
    }
}


