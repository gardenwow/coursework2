package com.example.coursework2.number2;

import com.example.coursework2.number2.Exceptions.QuestionAlreadyAddedException;
import com.example.coursework2.number2.Exceptions.QuestionNotFoundException;
import com.example.coursework2.number2.Service.Question;
import com.example.coursework2.number2.Service.QuestionServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class QuestionsTest {
    private final QuestionServiceImpl questionService = new QuestionServiceImpl();

    @Test
    public Question addQuestionTest(){
        Question question1 = new Question("privet", "poka");
        Question question2 = new Question("hello", "bye");
        questionService.addQuestion(question1.getQuestion(), question1.getAnswer());
        assertThat(questionService.getAll()).isNotEmpty().contains(question1);
        questionService.addQuestion(question2);
        assertThat(questionService.getAll()).isNotEmpty().contains(question2);
        return question1;
    }

    @Test
    public void addQuestionsErrorTest(){
        Question question = addQuestionTest();
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(()-> questionService.addQuestion(question));

    }
    @Test
    public void removeQuestionsTest(){
        Question question2 = new Question("hello", "bye");
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()->questionService.removeQuestion(question2.getQuestion(), question2.getAnswer()));
        Question question = addQuestionTest();
        assertThat(questionService.removeQuestion("hello", "bye")).isEqualTo(question2);

    }


}
