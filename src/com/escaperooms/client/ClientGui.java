package com.escaperooms.client;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.UserV2;
import com.escaperooms.gui.GameInterface;
import com.escaperooms.gui.controller.Controller;
import com.escaperooms.parsers.SpaceAdventureParser;
import com.escaperooms.spaceodyssey.SpaceGame;

import java.io.File;

public class ClientGui {
    public static void main(String[] args) {
        GameInterface gi = new GameInterface("Space Odyssey");
        Controller controller = new Controller();
        gi.setController(controller);
        controller.setGi(gi);
        GameRoom.user = new UserV2();
        File SPACE_FILE = new File("src/resources/data/space_odyssey.json");
        SpaceAdventureParser space_parser = new SpaceAdventureParser();
        SpaceGame spaceGame = space_parser.parse(SPACE_FILE);

        controller.setSpaceGame(spaceGame);
        spaceGame.linkGuiController(controller);

        gi.setVisible(true);
    }
}
