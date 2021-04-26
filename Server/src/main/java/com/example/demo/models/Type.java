package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "blitz")
    private String blitz;

    @Column(name = "subject")
    private String subject;

    @Column(name = "black_Box")
    private String blackBox;

    @Column(name = "multimedia")
    private String multimedia;

    public int getId() {
        return id;
    }

    public String getBlitz() {
        return blitz;
    }

    public void setBlitz(String blitz) {
        this.blitz = blitz;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBlackBox() {
        return blackBox;
    }

    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public String toString() {
        return "Type{" +
                "blitz='" + blitz + '\'' +
                ", subject='" + subject + '\'' +
                ", blackBox='" + blackBox + '\'' +
                ", multimedia='" + multimedia + '\'' +
                '}';
    }

    public Type() {
    }

    public Type(String blitz, String subject, String blackBox, String multimedia) {
        this.blitz = blitz;
        this.subject = subject;
        this.blackBox = blackBox;
        this.multimedia = multimedia;
    }
}
