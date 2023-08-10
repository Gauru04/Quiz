package com.example.SpringTest.service;

import com.example.SpringTest.dao.QuestionDao;
import com.example.SpringTest.dao.QuizDao;
import com.example.SpringTest.model.Question;
import com.example.SpringTest.model.QuestionWrapper;
import com.example.SpringTest.model.Quiz;
import com.example.SpringTest.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, String title) {
        System.out.println("In service");

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);


        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper( q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    public ResponseEntity<Map<String,Integer>> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = (Quiz) quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        Map<String,Integer> result=new HashMap<>();
        result.put("Correct_Answers",right);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    public ResponseEntity<List<Quiz>> getAll() {
        List<Quiz> all = quizDao.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);

    }


}
