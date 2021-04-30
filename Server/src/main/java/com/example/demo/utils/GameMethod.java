package com.example.demo.utils;

import com.example.demo.models.Answer;
import com.example.demo.models.Question;
import com.example.demo.repo.QuestionRepository;

public class GameMethod {
/*
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;

    /*
    Question question = questionRepository.findQuestionById();
    Answer answer = answerRepository.getAnswerByQuestion();
     */

    public void random(int max, int min) {
        max = 3;
        min = 1;
        max -= min;
        int id = (int) (Math.random() * ++max) + min;
    }



}

