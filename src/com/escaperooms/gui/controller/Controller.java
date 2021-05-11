package com.escaperooms.gui.controller;

import com.escaperooms.gui.GameInterface;
import com.escaperooms.spaceodyssey.SpaceGame;

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
}
