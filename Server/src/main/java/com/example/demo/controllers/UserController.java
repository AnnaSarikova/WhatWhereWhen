package com.example.demo.controllers;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/registration")
    public void regUser(@RequestBody Map<String, String> data) {

        String first_name = data.get("first_name");
        String second_name = data.get("second_name");
        String email = data.get("email");
        String password = data.get("password");

        User result = userService.create(first_name, second_name, email, password);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> read() {
        List<User> users = userRepository.findAll();
        return !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") Long id) {
        User user = userRepository.findById(id).orElse(null);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/user/{id}")
    public User update(@PathVariable(name = "id") Long userId, @RequestBody User userReq) {
        return userRepository.findById(userId).map(
                user -> {
                    user = userReq;
                    return userRepository.save(user);
                }
        ).orElseThrow(() -> new NotFoundException("Person not found with id" + userId));
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new NotFoundException("Person not found with id" + userId));
    }


    @GetMapping(value = "/auth", params = {"email", "password"})
    public ResponseEntity<User> auth(@RequestParam String email, @RequestParam String password) {

        UserService userService = new UserService(userRepository);
        User user = userService.checkauth(email, password);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }





}

