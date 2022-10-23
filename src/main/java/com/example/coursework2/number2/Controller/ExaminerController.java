package com.example.coursework2.number2.Controller;

import com.example.coursework2.number2.Service.ExaminerServiceImpl;
import com.example.coursework2.number2.Service.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ExaminerController {
    private final ExaminerServiceImpl examinerServiceImp;

    public ExaminerController(ExaminerServiceImpl examinerServiceImp) {
        this.examinerServiceImp = examinerServiceImp;
    }
    @GetMapping(path = "/exam1/get")
    public Collection<String> getQuestions(@RequestParam(name = "count") int count) {
        return examinerServiceImp.getQuestions(count);
    }

}
