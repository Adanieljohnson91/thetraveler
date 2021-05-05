package com.escaperooms.application;

import java.util.ArrayList;
import java.util.List;

public class TriviaV2 {
    private String question;
    private List<String> answers = new ArrayList<>();
    private String correctAnswer;

    TriviaV2(){

    }

    public TriviaV2(String question, List<String> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
