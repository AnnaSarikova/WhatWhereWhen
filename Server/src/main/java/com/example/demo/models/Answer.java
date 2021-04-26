package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public Answer() {
    }

    public Answer(String type) {
        this.type = type;
    }
}
