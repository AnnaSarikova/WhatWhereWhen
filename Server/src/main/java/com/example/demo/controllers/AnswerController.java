package com.example.demo.controllers;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Answer;
import com.example.demo.models.User;
import com.example.demo.repo.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(value = "/answer/{id_answer}")
    public ResponseEntity<Answer> read(@PathVariable(name = "idAnswer") Long id) {
        Answer answer = answerRepository.findById(id).orElse(null);

        return answer != null
                ? new ResponseEntity<>(answer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





}
