package com.example.demo.service;

import com.example.demo.models.Answer;
import com.example.demo.models.Question;
import com.example.demo.models.User;
import com.example.demo.repo.AnswerRepository;
import com.example.demo.repo.QuestionRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

/**
 *  answer service
 *  сервис ответов в котором прописаны методы для контроллеров
 */
@Service
public class AnswerService {
     private final AnswerRepository answerRepository;
     private UserRepository userRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;

    }

    /**
     * checkansw
     * проверка ответов
     * @param answer answer
     * @param id_question id_question
     * @return {@link boolean}
     */
    public boolean checkansw(String answer, String id_question) {
        if (answer.equalsIgnoreCase(String.valueOf((answerRepository.findById(Long.parseLong(id_question))).get().getAnswer()))){
            System.out.println("Ответы совпадают");
            return true;
        }
        else{
            System.out.println("Ответы не совпадают");
            return false;
        }


    }
}
