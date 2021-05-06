package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SpaceController implements Controller {
    private Map<String, SpaceCommands> commandMap = new HashMap<>();
    private SpaceCommands currentCommand;
    private String currentItem;

    SpaceController(){
        buildSpaceCommands();
    }

    @Override public void control(String input) {
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
            default:
                System.out.println("UNKNOWN");

        }
    }

    private void talk(){
        System.out.println("Talking");
    }

    private void use(){
        System.out.println("Using");
    }

    private void go(){
        System.out.println("Going");
    }

    private void unknown(){
        System.out.println("Unknowning");
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

    private void buildSpaceCommands(){
        SpaceCommands[] values = SpaceCommands.values();
        for(SpaceCommands cmd: values){
            commandMap.put(cmd.name(), cmd);
        }
    }


}
