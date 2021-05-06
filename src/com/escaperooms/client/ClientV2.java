package com.escaperooms.client;

import com.escaperooms.application.Game;
import com.escaperooms.application.GameRoom;
import com.escaperooms.joninexams.JoninGame;
import com.escaperooms.parsers.JoninGameParser;
import com.escaperooms.parsers.SpaceAdventureParser;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientV2 {
    public static void main(String[] args) throws IOException {
        List<Game> gameList = new ArrayList<>();
        File SPACE_FILE = new File("src/resources/data/space_odyssey.json");
        SpaceAdventureParser space_parser = new SpaceAdventureParser();

        File JONIN_FILE = new File("src/resources/data/jonin_game.json");
        JoninGameParser joninGameParser = new JoninGameParser();

        JoninGame joninGame = joninGameParser.parse(JONIN_FILE);
        SpaceGame spaceGame = space_parser.parse(SPACE_FILE);

        gameList.add(spaceGame);
        gameList.add(joninGame);
        GameRoom gameRoom = new GameRoom(gameList);
        gameRoom.play();

    }
}
