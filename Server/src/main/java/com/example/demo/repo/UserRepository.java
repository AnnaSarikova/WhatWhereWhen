package com.example.demo.repo;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select us from User us where us.email = :email")
    User findUserByEmail(@Param("email")String email);

    @Query
    String findUserByPassword(@Param("password") String password);
}
