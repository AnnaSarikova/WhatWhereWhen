package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 *  score controller
 *  контроллер для обработки баллов
 */
@RestController
public class ScoreController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    /**
     * up
     * обновление баллов пользователя
     * @param data data
     * @return {@link User}
     * @see User
     */
    @PostMapping(value = "/updatescore")
    public User up(@RequestBody Map<String, String> data){
        String id = data.get("id");
        String score = data.get("score");
        User user = userRepository.findUserById(Long.parseLong(id));
        return user;
    }
}
