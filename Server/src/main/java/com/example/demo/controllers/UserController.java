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

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/registration")
    public void create(@RequestParam String first_name,
                       @RequestParam String second_name,
                       @RequestParam String email,
                       @RequestParam String password) {
        UserService userService = new UserService(userRepository);
        User user = new User();
        user.setFirstName(first_name);
        user.setSecondName(second_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setScore(0L);

        userService.addUser(user);
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


}

