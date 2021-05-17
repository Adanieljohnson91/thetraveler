package com.escaperooms.gui.controller;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.UserV2;
import com.escaperooms.gui.GameInterface;
import com.escaperooms.music.MusicPlayer;
import com.escaperooms.parsers.SpaceAdventureParser;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.io.File;
import java.sql.PreparedStatement;
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
        //test code to make sure the end game dialog was working

        if ("win".equals(inputText)){
            triggerEndGame("you win", true);
            return;
        }
        else if ("lose".equals(inputText)){
            triggerEndGame("you died", false);
            return;
        }

        spaceGame.processUserInput(inputText);
    }

    public MusicPlayer getMusicPlayer(){
        return spaceGame.getMusicPlayer();
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

    public String fightTrivia(String question, List<String> answers, String actor_name){
        String key = actorTable.get(actor_name) + "_fight";

        return gameInterface.fightDialog(question,answers,key);
    }

    public void displayMessage(String message){
        gameInterface.showMessage(message);
    }

    public void triggerEndGame(String message, boolean success){
        /*
        int result = gameInterface.gameOver(message,success);
        if (result == -1 || result == 1){
            System.exit(0);
        }
        else{
            //System.out.println("restart");
            GameRoom.user = new UserV2();
            File SPACE_FILE = new File("src/resources/data/space_odyssey.json");
            SpaceAdventureParser space_parser = new SpaceAdventureParser();
            SpaceGame spaceGame = space_parser.parse(SPACE_FILE);
            setSpaceGame(spaceGame);
            spaceGame.linkGuiController(this);
            updateRoomText(spaceGame.getCurrentRoom().generateRoomText(false));
            gameInterface.showOpeningScene();
        }

         */
        gameInterface.showEndGame(message,success);
    }

    public void restartGame(){
        spaceGame.getMusicPlayer().stopMusic();
        GameRoom.user = new UserV2();
        File SPACE_FILE = new File("src/resources/data/space_odyssey.json");
        SpaceAdventureParser space_parser = new SpaceAdventureParser();
        SpaceGame spaceGame = space_parser.parse(SPACE_FILE);
        setSpaceGame(spaceGame);
        spaceGame.linkGuiController(this);
        updateRoomText(spaceGame.getCurrentRoom().generateRoomText(false));
        gameInterface.showOpeningScene();
    }

}
