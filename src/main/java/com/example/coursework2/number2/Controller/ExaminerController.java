package com.example.coursework2.number2.Controller;

import com.example.coursework2.number2.Service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "{count}")
    public Collection<String> getQuestions(@PathVariable("count") int count) {
        return examinerService.getQuestions(count);
    }

}
