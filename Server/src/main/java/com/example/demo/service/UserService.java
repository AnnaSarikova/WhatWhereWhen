package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 *  user service
 *  сервис пользователей в котором прописаны методы для контроллеров
 */
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * create
     * создание пользователя в базе данных
     * @param first_name first_name
     * @param second_name second_name
     * @param email email
     * @param password password
     * @return {@link User}
     * @see User
     */
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


    /**
     * checkauth
     * проверка пользователя в базе данных
     * @param email email
     * @param password password
     * @return {@link User}
     * @see User
     */
    public User checkauth(String email, String password) {
        User user = userRepository.findUserByEmail(email);

        if (user != null && user.getPassword(password).equals(password)){
            return user;
        }

        return null;


    }
    /**
     * user
     * создание рейтинга
     * @param score score
     * @return {@link Integer}
     * @see Integer
     */
    public Integer user( Long score){
        System.out.println(score);
        List<User> users = userRepository.findAll();
        users.sort(Collections.reverseOrder(User.COMPARE_BY_COUNT));
        int size = users.size();
        int place = 0;
        System.out.println(users);
        for (int i = size; i>0; i--){
            if (score > users.get(i-1).getScore()){
                place = i-1;

            }
        }
        System.out.println(place);
        return place;

    }






}
