package com.escaperooms.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.escaperooms.application.Game;
import com.escaperooms.application.GameRoom;
import com.fasterxml.jackson.databind.*;

public class SpaceAdventureParser {


    public void parse(File DATA) {

        final ObjectMapper objectMapper = new ObjectMapper();
        GameRoom game = null;

        try{
            game = objectMapper.readValue(DATA, GameRoom.class);
        }catch (IOException el){
            el.printStackTrace();
        }

        System.out.println(game.getGames());

    }

}
