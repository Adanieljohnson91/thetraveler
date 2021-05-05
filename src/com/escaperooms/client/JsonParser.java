package com.escaperooms.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.escaperooms.application.Game;
import com.escaperooms.application.GameRoom;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class JsonParser {
    public static void main(String[] args) throws IOException, ParseException {
        final File DATA = new File("src/resources/data/descriptions.json");

        final ObjectMapper objectMapper = new ObjectMapper();
        GameRoom game_room;
        try{
            game_room = objectMapper.readValue(DATA, GameRoom.class);
           // System.out.println(game_room);
        }catch (IOException el){
            el.printStackTrace();
        }

        GameRoom game = objectMapper.readValue(DATA, GameRoom.class);
        List<Game> gameName = game.getGames();
        System.out.println(game.getGames().get(0).getName());

    }

}
