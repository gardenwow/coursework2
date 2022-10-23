package com.example.coursework2.number2;

import com.example.coursework2.number2.Service.ExaminerServiceImpl;
import com.example.coursework2.number2.Service.Question;
import com.example.coursework2.number2.Service.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerTest {
    @Mock
    private QuestionServiceImpl questionService;
    @InjectMocks
    private ExaminerServiceImpl exServImp;

    @BeforeEach
    public void beforeEach(){
        when(questionService.getRandomQuestion()).thenReturn("how are you?");

    }


    @Test
    public void getExaminerTest(){
        assertThat(exServImp.getQuestions(1)).containsExactly("how are you?");
    }


}
