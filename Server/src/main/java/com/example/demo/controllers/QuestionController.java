package com.example.demo.controllers;

import com.example.demo.models.Question;
import com.example.demo.models.User;
import com.example.demo.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  question controller
 *  контроллер для обработки вопросов
 */
@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;


    /**
     * quest
     * отправка вопрос
     * @param data data
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see Question
     */
    @PostMapping(value = "/question")
    public ResponseEntity<Question> quest(@RequestBody Map<String,String> data){
        String id = data.get("id");
        Question question = questionRepository.findQuestionById(Long.valueOf(id));
        System.out.println(question);
        return question != null
                ? new ResponseEntity<>(question, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }

}
