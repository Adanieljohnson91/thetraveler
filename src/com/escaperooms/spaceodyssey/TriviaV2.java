package com.escaperooms.spaceodyssey;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TriviaV2 {
    private String question;
    private List<String> answers;
    private String correctAnswer;
    private Scanner scanner = new Scanner(System.in);

    @JsonCreator
    public TriviaV2(@JsonProperty("question") String question,
                    @JsonProperty("answers") List<String> answers,
                    @JsonProperty("correctAnswer") String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    private boolean checkAnswer(String answer){
        return answer.equalsIgnoreCase(correctAnswer);
    }
    private int checkAnswerFight(String answer){
        List<String> correctAnswer = List.of("Rock", "Paper", "Scissors");
        Random rand = new Random();
        int n = rand.nextInt(3);
        return checkRockPaperScissorsResults(answer,correctAnswer.get(n));
    }

    public boolean quiz(){
        return checkAnswer(SpaceGame.guiController.askTrivia(question,answers, SpaceGame.CURRENT_ROOM.getName()));
    }
    public boolean quizFight(String actorName){
        //return checkAnswerFight(SpaceGame.guiController.fightTrivia("Rock... Paper... Scissors... SHOOT!",List.of("Rock", "Paper", "Scissors")));
        int playerHP = 5;
        int actorHP = 5;
        boolean done = false;
        while (!done){
            int winnerResult = checkAnswerFight(SpaceGame.guiController.fightTrivia("Player HP: " + playerHP +
                            "\nOpponent HP: " + actorHP +
                            "\n" +
                            "Rock... Paper... Scissors... SHOOT!",
                    List.of("Rock", "Paper", "Scissors"),actorName));
            if (winnerResult == 1){
                actorHP--;
            }
            else if (winnerResult == 2){
                playerHP--;
            }
            else if (winnerResult == 0){
                actorHP--;
                playerHP--;
            }
            if (playerHP == 0  || actorHP == 0){
                done = true;
            }
        }
        return playerHP == 0 ? false : true;
    }

    // returns 1 if p1 wins, 2 if p2 wins, 0 if tie and -1 if error
    int checkRockPaperScissorsResults(String p1Choice,String p2Choice){
        int result = -1;
        if ("rock".equalsIgnoreCase(p1Choice)){
            if ("rock".equalsIgnoreCase(p2Choice)){
                result = 0;
            }
            else if ("paper".equalsIgnoreCase(p2Choice)){
                result = 2;
            }
            else if ("scissors".equalsIgnoreCase(p2Choice)){
                result = 1;
            }
        }
        else if ("paper".equalsIgnoreCase(p1Choice)){
            if ("rock".equalsIgnoreCase(p2Choice)){
                result = 1;
            }
            else if ("paper".equalsIgnoreCase(p2Choice)){
                result = 0;
            }
            else if ("scissors".equalsIgnoreCase(p2Choice)){
                result = 2;
            }
        }
        else if ("scissors".equalsIgnoreCase(p1Choice)){
            if ("rock".equalsIgnoreCase(p2Choice)){
                result = 2;
            }
            else if ("paper".equalsIgnoreCase(p2Choice)){
                result = 1;
            }
            else if ("scissors".equalsIgnoreCase(p2Choice)){
                result = 0;
            }
        }
        return result;
    }
}
