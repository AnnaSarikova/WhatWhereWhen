package sample.model;

public class Question {
    private Long id_question;
    private String questions;

    public Long getId() {
        return id_question;
    }

    public void setId(long id) {
        this.id_question = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
