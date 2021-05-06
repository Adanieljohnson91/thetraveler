package com.escaperooms.client;

import com.escaperooms.application.Game;
import com.escaperooms.application.GameRoom;
import com.escaperooms.application.UserV2;
import com.escaperooms.parsers.SpaceAdventureParser;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientV2 {
    public static void main(String[] args) throws IOException {
        List<Game> gameList = new ArrayList<>();
        File DATA = new File("src/resources/data/descriptions.json");
        SpaceAdventureParser parser = new SpaceAdventureParser();
        SpaceGame game = parser.parse(DATA);
        gameList.add(game);
        GameRoom gameRoom = new GameRoom(gameList, new UserV2());
        gameRoom.play();
    }
}
