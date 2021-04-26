package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @ManyToMany(mappedBy = "user")
    private List<Question> question;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name" )
    private String FirstName;

    @Column(name = "second_name")
    private String SecondName;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User(){}

    public User(String firstName, String secondName,String email, String sex){
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.email = email;
        this.sex = sex;
    }
}
