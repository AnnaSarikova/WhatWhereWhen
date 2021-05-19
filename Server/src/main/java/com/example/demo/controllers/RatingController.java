package com.example.demo.controllers;

import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 *  rating controller
 *  контроллер для обработки рейтинга
 */
@RestController
public class RatingController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    /**
     * rat
     * возвращает на каком месте пользователей среди всех
     * @param data data
     * @return {@link Integer}
     * @see Integer
     */
    @PostMapping(value = "/rating")
    public Integer rat(@RequestBody Map<String,Long> data){
        Long score  =data.get("score");
        int rating = userService.user(score);

        return rating;

    }
}
