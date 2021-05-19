package com.example.demo.repo;

import com.example.demo.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  answer repository
 *  Репозиторий Jpa для создания CRUD-запросов для таблицы answer
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
