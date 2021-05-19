package com.example.demo.repo;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;


/**
 *  user repository
 *  Репозиторий Jpa для создания CRUD-запросов для таблицы user
 */
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select us from User us where us.email = :email")
    User findUserByEmail(@Param("email")String email);

    @Query("select us from User us where us.id = :id")
    User findUserById(@Param("id") Long id);


}
