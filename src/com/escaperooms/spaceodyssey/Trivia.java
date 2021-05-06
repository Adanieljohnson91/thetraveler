package com.escaperooms.spaceodyssey;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Trivia {
    String name;
    String question;
    String correctAnswer;
    String answerA;
    String answerB;
    String answerC;
    String answerD;
    Prompter prompter = new Prompter(new Scanner(System.in));
    public Trivia(String name, String question, String correctAnswer, String answerA, String answerB, String answerC, String answerD){
setName(name);
setQuestion(question);
setCorrectAnswer(correctAnswer);
setAnswerA(answerA);
setAnswerB(answerB);
setAnswerC(answerC);
setAnswerD(answerD);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getCorrectAnswer() {
        return correctAnswer;
    }

    private String getQuestion() {
        return question;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    private void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    private String getAnswerA() {
        return answerA;
    }

    private void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    private String getAnswerB() {
        return answerB;
    }

    private void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    private String getAnswerC() {
        return answerC;
    }

    private void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    private String getAnswerD() {
        return answerD;
    }

    private void setAnswerD(String answerD) {
        this.answerD = answerD;
    }
    public boolean ask (){
        List<String> validAnswers = Arrays.asList(getAnswerA().toUpperCase(), getAnswerB().toUpperCase(), getAnswerC().toUpperCase(), getAnswerD().toUpperCase());
        boolean result = false;
        String userAnswer = prompter.prompt(getQuestion()+"\nA : "+getAnswerA()+"\nB : "+getAnswerB()+"\nC : "+getAnswerC()+"\nD : "+getAnswerD()+"\n","A|B|C|D|a|b|c|d"+"|"+getAnswerA()+"|"+getAnswerB()+"|"+getAnswerC()+"|"+getAnswerD()+"|"+getAnswerA().toLowerCase()+"|"+getAnswerB().toLowerCase()+"|"+getAnswerC().toLowerCase()+"|"+getAnswerD().toLowerCase()+"|"+getAnswerA().toUpperCase()+"|"+getAnswerB().toUpperCase()+"|"+getAnswerC().toUpperCase()+"|"+getAnswerD().toUpperCase(),"Not a valid answer try again").toUpperCase();
        if(userAnswer.equals(getCorrectAnswer()) || validAnswers.contains(userAnswer)){
            System.out.println("You are correct!");
            result = true;
        }else{
            System.out.println("Wrong Answer!");
            result = false;
        }
        return result;
    }
}