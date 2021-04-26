package com.example.demo.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "questions")
    private String questions;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "questionSet")
    private Set<User> users;

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
