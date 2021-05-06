package com.escaperooms.parsers;

import java.io.File;
import java.io.IOException;

import com.escaperooms.application.GameRoom;
import com.escaperooms.spaceodyssey.SpaceGame;
import com.fasterxml.jackson.databind.*;

public class SpaceAdventureParser {


    public SpaceGame parse(File DATA) {

        final ObjectMapper objectMapper = new ObjectMapper();
        SpaceGame game = null;

        try{
            game = objectMapper.readValue(DATA, SpaceGame.class);
        }catch (IOException el){
            el.printStackTrace();
        }

       return game;

    }

}
