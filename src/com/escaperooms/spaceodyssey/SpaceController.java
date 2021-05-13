package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Controller;
import com.escaperooms.application.GameRoom;

import java.util.*;

public class SpaceController implements Controller {
    private Map<String, SpaceCommands> commandMap = new HashMap<>();
    private SpaceCommands currentCommand;
    private String currentInput;

    SpaceController() {
        buildSpaceCommands();
    }

    @Override
    public void control(String input) {
        this.currentInput = input;
        parseInputs(input);
        switch (currentCommand) {
            case USE:
                use();
                break;
            case GO:
                go();
                break;
            case TALK:
                talk();
                break;
            case UNKNOWN_COMMAND:
                unknown(input);
                break;
            case HELP:
                help();
                break;
            case VIEW:
                view();
                break;
            case LOOK:
                look();
                break;
            case EXIT:
                System.exit(0);
            default:
                System.out.println("UNKNOWN");

        }
    }

    private void talk() {
        SpaceGame.CURRENT_ROOM.getActor().interact();
    }

    private void use() {
        System.out.println("Using");
    }

    private void go() {
        String whereIWantToGo = findValidWordInStringFromArrayOfStrings(this.currentInput);
        if (!checkAccess(whereIWantToGo)) {
            //System.out.println("Sorry champ, looks like you don't have what it takes to go to "+ whereIWantToGo);
            //blockedText = "Sorry champ, looks like you don't have what it takes to go to " + whereIWantToGo;
            SpaceGame.guiController.displayMessage("Sorry champ, looks like you don't have what it takes to go to " + whereIWantToGo);
        }
        else {
            SpaceGame.setCurrentRoom(SpaceGame.ROOMMAP
                    .get(whereIWantToGo));
        }
        String roomText = SpaceGame.CURRENT_ROOM.generateRoomText(false);
        roomText += "\n\nInventory:\n" + GameRoom.user.getInventoryList();
        SpaceGame.guiController.updateRoomText(roomText);
    }

    private boolean checkAccess(String input) {
        var bool = false;
        //DOES USER HAVE THE REQUIRED ITEM OF THE ROOM?
        if (GameRoom.user.hasItem(SpaceGame.ROOMMAP.get(input).getRequiredItem())) {
            bool = true;
        }
        return bool;
    }

    private void unknown(String input){
        //System.out.println("Sorry folk person, that's not going to work, if you need HELP, just ask \n YOUR INPUT: " + input);
        SpaceGame.guiController.displayMessage("Sorry folk person, that's not going to work, if you need HELP, just ask. \n\n YOUR INPUT: " + input);
    }

    private String isCleared(String x) {
        if (!SpaceGame.ROOMMAP.get(x).getActor().getIsAlive()) {
            return " CLEARED";
        }
        return "";
    }

    private void view() {
        /*
        SpaceGame.CURRENT_ROOM.getAdjacent_rooms().forEach(x -> {
            System.out.println(x + this.isCleared(x));
        });
         */
        String roomText = SpaceGame.CURRENT_ROOM.generateRoomText(true);
        roomText += "\n\nInventory:\n" + GameRoom.user.getInventoryList();
        SpaceGame.guiController.updateRoomText(roomText);
    }

    private void look() {
        UsefulItem item = findValidItemInInput(this.currentInput);
        if (item != null){
            //System.out.println("The inscription for " + item.getName() + " is " + "'" + item.getDialogs() + "'.");
            String roomText = SpaceGame.CURRENT_ROOM.generateRoomText(true);
            roomText += "\n\nThe inscription on " + item.getName() + "reads '" + item.getDialogs() + "'";
            roomText += "\n\nInventory:\n" + GameRoom.user.getInventoryList();
            SpaceGame.guiController.updateRoomText(roomText);
        }
        else {
            //System.out.println("You don't seem to have that item.");
            SpaceGame.guiController.displayMessage("You don't seem to have that item.");
        }

    }

    private void help() {
        /*
        System.out.println("Available Commands");
        for (String cmd : commandMap.keySet()) {
            System.out.println(cmd);
        }
         */
        List<String> commandList =  new ArrayList<>();
        for (String cmd : commandMap.keySet()) {
            if (!"UNKNOWN_COMMAND".equals(cmd))
                commandList.add(cmd);
        }
        String message = "Available Commands:\n\n";
        message += String.join(", ",commandList);
        SpaceGame.guiController.displayMessage(message);
    }

    /**
     * @param input is the input from the user, parseInputs will look through the
     *              text and pull out commands and items comparing to global item lists
     *              and global room commands.
     */
    private void parseInputs(String input) {

        String[] inputs = input.split(" ");
        currentCommand = getCommand(inputs);
    }

    private SpaceCommands getCommand(String[] sentence) {
        SpaceCommands cmd = SpaceCommands.UNKNOWN_COMMAND;
        for (String word : sentence) {
            String current = word.toUpperCase(Locale.ROOT);
            if (commandMap.containsKey(current)) {
                cmd = commandMap.get(current);
                break;
            }
        }
        return cmd;
    }

    public String findValidWordInStringFromArrayOfStrings(String sentence) {
        String next = SpaceGame.CURRENT_ROOM.getName();
        List<String> ac = SpaceGame.CURRENT_ROOM.getAdjacent_rooms();
        for (String word : ac) {
            if (wordInSentence(sentence, word)) {
                next = word;
                break;
            }
        }
        return next;
    }

    public UsefulItem findValidItemInInput(String sentence){
        UsefulItem item = null;
        List<UsefulItem> inventory = GameRoom.user.getInventoryItems();
        for (UsefulItem invItem : inventory){
            if (wordInSentence(sentence,invItem.getName())){
                item = invItem;
                break;
            }
        }
        return item;
    }

    public boolean wordInSentence(String sentence, String word) {

        boolean res = false;
        for (int i = 0; i < sentence.length() - (word.length() - 1); i++) {
            String currentWord = sentence.substring(i, word.length() + i);
            if (currentWord.equalsIgnoreCase(word)) {
                res = true;
                break;
            }
        }
        return res;
    }

    private void buildSpaceCommands() {
        SpaceCommands[] values = SpaceCommands.values();
        for (SpaceCommands cmd : values) {
            commandMap.put(cmd.name(), cmd);
        }
    }


}
