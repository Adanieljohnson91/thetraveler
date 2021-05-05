package com.escaperooms.client;

import com.escaperooms.parsers.SpaceAdventureParser;

import java.io.File;
import java.io.IOException;

public class ClientV2 {
    public static void main(String[] args) throws IOException {
        File DATA = new File("src/resources/data/descriptions.json");
        SpaceAdventureParser parser = new SpaceAdventureParser();
        parser.parse(DATA);
    }
}
