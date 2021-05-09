package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Controller;
import com.escaperooms.application.Game;
import com.escaperooms.application.GameRoom;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SpaceController implements Controller {
    private Map<String, SpaceCommands> commandMap = new HashMap<>();
    private SpaceCommands currentCommand;
    private String currentItem;
    private String currentInput;

    SpaceController(){
        buildSpaceCommands();
    }

    @Override public void control(String input) {
        this.currentInput = input;
        parseInputs(input);
        switch (currentCommand){
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
                unknown();
                break;
            case HELP:
                help();
                break;
            case VIEW:
                view();
                break;
            case EXIT:
                System.exit(0);
            default:
                System.out.println("UNKNOWN");

        }
    }

    private void talk(){
        SpaceGame.CURRENT_ROOM.getActor().interact();
    }

    private void use(){
        System.out.println("Using");
    }

    private void go(){
       SpaceGame.CURRENT_ROOM = SpaceGame.ROOMMAP
               .get(findValidWordInStringFromArrayOfStrings(this.currentInput));
    }

    private void unknown(){
        System.out.println("Unknowning");
    }

    private void view(){
        SpaceGame.CURRENT_ROOM.getAdjacent_rooms().forEach(System.out::println);
    }

    private void help(){
        System.out.println("Available Commands");
        for(String cmd: commandMap.keySet()){
            System.out.println(cmd);
        }
    }

    /**
     *
     * @param input is the input from the user, parseInputs will look through the
     *              text and pull out commands and items comparing to global item lists
     *              and global room commands.
     */
    private void parseInputs(String input){

        String[] inputs = input.split(" ");
        currentCommand = getCommand(inputs);
    }

    private SpaceCommands getCommand(String[] sentence){
        SpaceCommands cmd = SpaceCommands.UNKNOWN_COMMAND;
        for(String word: sentence){
            String current = word.toUpperCase(Locale.ROOT);
            if(commandMap.containsKey(current)){
                cmd = commandMap.get(current);
                break;
            }
        }
        return cmd;
    }

    public String findValidWordInStringFromArrayOfStrings(String sentence){
        String next = SpaceGame.CURRENT_ROOM.getName();
        List<String> ac  = SpaceGame.CURRENT_ROOM.getAdjacent_rooms();
        for(String word: ac){
            if(wordInSentence(sentence, word)){
                next = word;
                break;
            }
        }
        return next;
    }
    public boolean wordInSentence(String sentence, String word){

        boolean res = false;
        for(int i = 0; i < sentence.length() - (word.length() - 1); i++){
            String currentWord = sentence.substring(i, word.length() + i);
            if(currentWord.equalsIgnoreCase(word)){
                res = true;
                break;
            }
        }
        return res;
    }



    private void buildSpaceCommands(){
        SpaceCommands[] values = SpaceCommands.values();
        for(SpaceCommands cmd: values){
            commandMap.put(cmd.name(), cmd);
        }
    }


}
