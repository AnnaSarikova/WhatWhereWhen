package com.example.demo.controllers;

import com.example.demo.models.Question;
import com.example.demo.models.User;
import com.example.demo.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    /*
    @GetMapping(value = "/question/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") Long id) {
        Question question = questionRepository.findById(id).orElse(null);

        return question != null
                ? new ResponseEntity<>(question, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     */
}
