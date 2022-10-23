package com.example.coursework2.number2.Service;

import java.util.Collection;

public interface QuestionServiceInterf {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);

    Question removeQuestion(String question, String answer);

    Collection<Question> getAll();

    String getRandomQuestion();
}
