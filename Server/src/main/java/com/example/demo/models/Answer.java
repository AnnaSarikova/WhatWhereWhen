package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnswer;

    @Column(name = "answer")
    private String answer;




    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Question question;

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getType() {
        return answer;
    }

    public void setType(String type) {
        this.answer = type;
    }



    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + idAnswer +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Answer() {
    }

    public Answer(String type) {
        this.answer = type;
    }
}
