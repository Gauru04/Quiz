package com.example.SpringTest.controller;


import com.example.SpringTest.model.QuestionWrapper;
import com.example.SpringTest.model.Quiz;
import com.example.SpringTest.model.Response;
import com.example.SpringTest.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// controller for quiz
@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,  @RequestParam String title){
        System.out.println("In controller");
        return quizService.createQuiz(category, title);
    }



    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Map<String,Integer>> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

    @GetMapping("/allQuiz")
    public ResponseEntity<List<Quiz>> getAll(){
        return quizService.getAll();
    }

}
