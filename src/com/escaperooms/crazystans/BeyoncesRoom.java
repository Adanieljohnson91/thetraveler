package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

class BeyoncesRoom {
    private Hinter hinter;

    String start() {
        generateHints();
        System.out.println(welcomeMessage());
        askQuestion();
        return "beyoncesGrammy";
    }

    private void askQuestion() {
        String hint = EscapeRoom.prompt("What album won Beyonce her first solo Grammy? ",
                challengeAnswer() + "|hint", "That is not the correct answer.");
        if (hint.equals("hint")) {
            hintChecker();
        }
    }

    private void generateHints() {
        hinter = new Hinter("It was her debut solo album.", "It was a love of the dangerous type");
    }

    private void hintChecker() {
        if (hinter.isEmpty()) {
            System.out.println("NO MORE HINTS! SOLVE IT! USE GOOGLE!");
        } else {
            System.out.println("Hint: " + hinter.getHint());
        }
        askQuestion();
    }

    private String welcomeMessage() {
        return "Welcome to the Crazy Stans Beyonce room.";
    }

    private String challengeAnswer() {
        return "dangerously in love";
    }

}
