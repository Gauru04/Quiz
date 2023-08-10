package com.example.SpringTest.controller;

import com.example.SpringTest.model.Question;
import com.example.SpringTest.model.QuestionWrapper;
import com.example.SpringTest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/home")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {

     return questionService.getAllQuestions();
       // return questionService.getAllQuestions();
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @GetMapping("/allCategories")
    public ResponseEntity<List<String>> getCategories() {
        return questionService.getAllCategories();

    }

}