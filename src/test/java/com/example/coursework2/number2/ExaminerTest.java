package com.example.coursework2.number2;

import com.example.coursework2.number2.Service.ExaminerServiceImpl;
import com.example.coursework2.number2.Service.Question;
import com.example.coursework2.number2.Service.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ExaminerTest {
    @Mock
    private QuestionServiceImpl questionService;
    @InjectMocks
    private ExaminerServiceImpl exServImp;

    @BeforeEach
    public void beforeStart() {
        when(questionService.getAll()).thenReturn(Arrays.asList(

                new Question("How are you?", "good"),
                new Question("what are u doing?", "relax man, i`m played doka2"),
                new Question("doka2? what?", "yes, i dont know, just fun")));
    }

   // @ParameterizedTest
  //  @MethodSource("getRandomQue")
    @Test
    public void getExaminerTest() {


        when(questionService.getRandomQuestion()).thenReturn("how are you?");
        assertThat(exServImp.getQuestions(1)).containsExactly("how are you?");
       // when((verify(questionService.getRandomQuestion(), times(3))))
        //        .thenReturn("How are you?", "what are u doing", "doka2? what?");


       // assertThat(exServImp.getQuestions(3))
       //         .containsExactly("How are you?", "what are u doing", "doka2? what?");
    }
    public static Stream<Arguments> getRandomQue(){
        return Stream.of(
                Arguments.of("How are you?", "what are u doing", "doka2? what?" ),
                Arguments.of("what are u doing", "doka2? what?", "How are you?")
        );
    }

    @Test
    public void getExaminerTest3(){

    }

}
