package com.example.demo.repo;

import com.example.demo.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query
    Question findQuestionById(Long id);


}
