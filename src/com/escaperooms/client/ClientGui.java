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
        GameInterface gi = new GameInterface("Test");
        Controller controller = new Controller();
        gi.setController(controller);
        controller.setGi(gi);

        File SPACE_FILE = new File("src/resources/data/space_odyssey.json");
        SpaceAdventureParser space_parser = new SpaceAdventureParser();
        SpaceGame spaceGame = space_parser.parse(SPACE_FILE);

        controller.setSpaceGame(spaceGame);
        spaceGame.linkGuiController(controller);

        GameRoom.user = new UserV2();

        gi.setVisible(true);
    }
}
