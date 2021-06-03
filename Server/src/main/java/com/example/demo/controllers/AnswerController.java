package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.repo.AnswerRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 *  answer controller
 *  контроллер для обработки вопроса
 */
@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;
    private final AnswerService answerService;
    private final UserRepository userRepository;

    public AnswerController(AnswerService answerService, UserRepository userRepository) {
        this.answerService = answerService;
        this.userRepository = userRepository;
    }

    /**
     * answ
     * проверка правильности ответа
     * @param data data
     * @return {@link User}
     * @see User
     */
    @PostMapping(value = "/answer")
    public User answ(@RequestBody Map<String,String> data) {
        String answer = data.get("answer");
        String id_question = data.get("id_question");
        String id = data.get("id");
        boolean ans = answerService.checkansw(answer, id_question);
        if (ans){
            User user = userRepository.findById(Long.parseLong(id)).orElse(null);
            user.setScore(user.getScore() + 1);
            return userRepository.saveAndFlush(user);
        }
        else {
            User user = userRepository.findById(Long.parseLong(id)).orElse(null);
            return user;
        }
    }
}
