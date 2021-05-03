package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;

class MichaelJacksonsRoom {
    private Hinter hinter;

    String start() {
        generateHints();
        System.out.println(welcomeMessage());
        askQuestion();
        return "michaelJacksonsGlove";
    }

    private void askQuestion() {
        String hint = EscapeRoom.prompt("In the song Billie Jean, what did Michael Jackson state Billie Jean was more like? ",
                challengeAnswer() + "|hint", "That is not the correct answer.");
        if (hint.equals("hint")) {
            hintChecker();
        }
    }

    private void generateHints() {
        hinter = new Hinter("Not a king but a...", "Synonymous with pretty.");
    }

    private void hintChecker() {
        if (hinter.isEmpty()) {
            System.out.println("NO MORE HINTS! SOLVE IT! beauty...");
        } else {
            System.out.println("Hint: " + hinter.getHint());
        }
        askQuestion();
    }

    private String welcomeMessage() {
        return "Welcome to the Crazy Stans' Michael Jackson room.";
    }

    private String challengeAnswer() {
        return "beauty queen";
    }
}