package com.escaperooms.parsers;

import java.io.File;
import java.io.IOException;

import com.escaperooms.application.GameRoom;
import com.fasterxml.jackson.databind.*;

public class SpaceAdventureParser {


    public GameRoom parse(File DATA) {

        final ObjectMapper objectMapper = new ObjectMapper();
        GameRoom game = null;

        try{
            game = objectMapper.readValue(DATA, GameRoom.class);
        }catch (IOException el){
            el.printStackTrace();
        }

       return game;

    }

}
