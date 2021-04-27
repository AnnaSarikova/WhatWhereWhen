package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
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

    public List<User> getAllUsers() { return userRepository.findAll(); }


    public User getById(Long id) { return userRepository.getOne(id); }

    public  User addUser(User user) { return userRepository.saveAndFlush(user); }
}
