package com.escaperooms.gui.controller;

import com.escaperooms.gui.GameInterface;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.util.List;

public class Controller {
    GameInterface gameInterface;
    SpaceGame spaceGame;

    public void setGi(GameInterface gi) {
        this.gameInterface = gi;
    }

    public void setSpaceGame(SpaceGame spaceGame) {
        this.spaceGame = spaceGame;
    }

    // Controls for the GUI to talk to the game
    public void submitUserInput(String inputText){
        spaceGame.processUserInput(inputText);
    }

    // Controls for the game to talk to the UI
    public void updateRoomText(String roomText){
        gameInterface.setRoomTextTA(roomText);
    }

    public String fightORQuestionDialog(String question, List<String> answers){
        return gameInterface.twoAnswerDialog(question,answers);
    }

    public String askTrivia(String question, List<String> answers){
        return gameInterface.triviaDialog(question,answers);
    }

    public String fightTrivia(String question, List<String> answers){
        return gameInterface.fightDialog(question,answers);
    }
}
