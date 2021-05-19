package com.example.demo.repo;

import com.example.demo.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *  question repository
 *  Репозиторий Jpa для создания CRUD-запросов для таблицы question
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query
    Question findQuestionById(Long id);


}
