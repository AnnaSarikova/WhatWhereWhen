package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User create(String first_name, String second_name, String email, String password) {


        User newUser = new User();

        newUser.setFirstName(first_name);
        newUser.setSecondName(second_name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setScore(0L);

        userRepository.save(newUser);
        return newUser;
    }
}
