package com.escaperooms.gui.controller;

import com.escaperooms.gui.GameInterface;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.util.HashMap;
import java.util.List;

public class Controller {
    GameInterface gameInterface;
    SpaceGame spaceGame;
    HashMap<String,String> actorTable;

    public Controller() {
        actorTable = new HashMap<>();
        actorTable.put("Diego the Wide Mouthed Duck","duck");
        actorTable.put("Bunny Bunny Big Skins","bunny");
        actorTable.put("Mad Bat","bat");
        actorTable.put("Arty the Alligator","alligator");
        actorTable.put("Filthy the Bear","bear");
        actorTable.put("Frisky Whiskers","cat");
        actorTable.put("Big Daddy the Devilishly Handsome Donkey","donkey");

    }

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

    public String fightORQuestionDialog(String question, List<String> answers, String actor_name){
        String key = actorTable.get(actor_name) + "_general";
        return gameInterface.twoAnswerDialog(question,answers,key);
    }

    public String askTrivia(String question, List<String> answers,String actor_name){
        String key = actorTable.get(actor_name) + "_quiz";
        return gameInterface.triviaDialog(question,answers, key);
    }
}
