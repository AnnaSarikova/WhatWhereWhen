package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAnswer;

    @Column(name = "type")
    private String type;


    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
    private Question question;

    public int getId() {
        return idAnswer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.idAnswer = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + idAnswer +
                ", type='" + type + '\'' +
                '}';
    }

    public Answer() {
    }

    public Answer(String type) {
        this.type = type;
    }
}
