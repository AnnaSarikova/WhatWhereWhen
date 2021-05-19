package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  user controller
 *  котроллер для обработки юзера
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * reg user
     * регистрация юзера
     * @param data data
     */
    @PostMapping(value = "/registration")
    public void regUser(@RequestBody Map<String, String> data) {

        String first_name = data.get("first_name");
        String second_name = data.get("second_name");
        String email = data.get("email");
        String password = data.get("password");

        User result = userService.create(first_name, second_name, email, password);
    }


    /**
     * auth
     * авторизация юзера
     * @param data data
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see User
     */
    @PostMapping(value = "/auth")
    public ResponseEntity<User> auth(@RequestBody Map<String, String> data) {


        String email = data.get("email");
        String password = data.get("password");


        UserService userService = new UserService(userRepository);
        User user = userService.checkauth(email, password);



        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }





}

