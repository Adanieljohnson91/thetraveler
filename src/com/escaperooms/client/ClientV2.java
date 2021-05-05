package com.escaperooms.client;

import com.escaperooms.application.GameRoom;
import com.escaperooms.parsers.SpaceAdventureParser;

import java.io.File;
import java.io.IOException;

public class ClientV2 {
    public static void main(String[] args) throws IOException {
        File DATA = new File("src/resources/data/descriptions.json");
        SpaceAdventureParser parser = new SpaceAdventureParser();
        GameRoom game = parser.parse(DATA);
        game.getGames().get(0).getCurrentRoom().getAdjacent_rooms().forEach(System.out::println);
    }
}
