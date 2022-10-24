package com.example.coursework2.number2.Service;

import com.example.coursework2.number2.Exceptions.QuestionAlreadyAddedException;
import com.example.coursework2.number2.Exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionServiceInterf {
   private final List<Question> questions = new ArrayList<>(List.of(
            new Question("How are you?", "good"),
            new Question("what are u doing?", "relax man, i`m played doka2"),
            new Question("doka2? what?", "yes, i dont know, just fun")));

    @Override
    public Question addQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            throw new QuestionAlreadyAddedException();

        }
        questions.add(question1);
        return question1;

    }

    @Override
    public Question addQuestion(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException();

        }
        questions.add(question);
        return question;

    }


    @Override
    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            questions.remove(question1);
            return question1;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public String getRandomQuestion() {

        var random = new Random();
        var randomQuestion = questions.get(random.nextInt(questions.size())).getQuestion();
        return randomQuestion;
    }

}
