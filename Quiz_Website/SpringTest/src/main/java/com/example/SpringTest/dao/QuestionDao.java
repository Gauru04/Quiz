package com.example.SpringTest.dao;

import com.example.SpringTest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findRandomQuestionsByCategory(String category);

    List<Question> findByCategory(String category);

    @Query("select category from Question")
    List<String> findAllCategories();



}
