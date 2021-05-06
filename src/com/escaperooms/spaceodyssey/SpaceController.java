package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Controller;

import java.util.List;

public class SpaceController implements Controller {
    private String currentCommand;
    private String currentItem;



    @Override public void control(String input) {

    }

    private void talk(){

    }

    private void use(){

    }

    private void go(){

    }

    private void help(){

    }

    /**
     *
     * @param input is the input from the user, parseInputs will look through the
     *              text and pull out commands and items comparing to global item lists
     *              and global room commands.
     */
    private void parseInputs(String input){
        String[] inputs = input.split(" ");
    }
}
