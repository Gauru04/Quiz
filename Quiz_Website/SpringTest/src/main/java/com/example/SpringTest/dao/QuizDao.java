package com.example.SpringTest.dao;

import com.example.SpringTest.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao<Quiz> extends JpaRepository<com.example.SpringTest.model.Quiz,Integer> {
    @Override
    List<com.example.SpringTest.model.Quiz> findAll();
}
