package com.example.coursework2.number2.Service;

import com.example.coursework2.number2.Exceptions.BadRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionServiceImpl questionService;

    public ExaminerServiceImpl(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<String> getQuestions(int count) {
        Set<String> outQuestions = new HashSet<>();
        for (int i = 0; i <= count; i++) {

            outQuestions.add(questionService.getRandomQuestion());

        }
        if (outQuestions.size() == count) {
            return outQuestions;
        }
        throw new BadRequest();

    }
     /*  List<String> questionExam =  questionService.questions.stream()
               .map(e -> e.getQuestion()).
               collect(Collectors.toList());
       Set<String> outQuestions = new HashSet<>(questionExam);*/


/*    public void showUniqueRandomQuestions(Set<String> question, int size) {
        var random = new Random();
        var list = new ArrayList<>(question);
        if (question.size() < size) {
            for (int i = 0; i < size; i++) {
                int randomIndex = random.nextInt(list.size());
                var randomElement = list.get(randomIndex);
            }
        }
        throw new BadRequest();
    }

 */

}
