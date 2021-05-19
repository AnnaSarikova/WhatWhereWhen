package com.example.demo.models;

import javax.persistence.*;
import java.util.Comparator;


/**
 *  user
 *  модель для таблицы пользователя
 */
@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name" )
    private String FirstName;

    @Column(name = "second_name")
    private String SecondName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "score")
    private Long score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                " id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }

    public User(){}

    public User(String firstName, String secondName,String email, String password){
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.email = email;
        this.password = password;
    }
    public static final Comparator<User> COMPARE_BY_COUNT = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return (int) (o1.getScore() - o2.getScore());
        }
    };
}
