package com.example.coursework2.number2.Service;

import com.example.coursework2.number2.Exceptions.BadRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionServiceInterf questionServiceInterf;

    public ExaminerServiceImpl(QuestionServiceInterf questionServiceInterf) {
        this.questionServiceInterf = questionServiceInterf;
    }


    @Override
    public Collection<String> getQuestions(int count) {
        Set<String> outQuestions = new HashSet<>();
        if (count > 0 && count <= questionServiceInterf.getAll().size()) {
            while (outQuestions.size() < count) {
                outQuestions.add(questionServiceInterf.getRandomQuestion());
            }

        }
        return outQuestions;
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
