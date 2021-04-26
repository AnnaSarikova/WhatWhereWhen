package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question")
public class Question {
    @ManyToMany
    private List<User> user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "questions")
    private String questions;

    @Column(name = "type")
    private String type;

    public int getId() {
        return id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questions='" + questions + '\'' +
                ", type=" + type +
                '}';
    }

    public Question() {
    }

    public Question(String questions, String type) {
        this.questions = questions;
        this.type = type;
    }


}
