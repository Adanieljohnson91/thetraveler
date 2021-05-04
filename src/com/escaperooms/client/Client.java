package com.escaperooms.client;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;

import java.io.IOException;

class Client {

    public static void main(String[] args) throws IOException {
        System.out.println(" _____                   _           \n" +
                "|_   _|                 | |          \n" +
                "  | |_ __ __ ___   _____| | ___ _ __ \n" +
                "  | | '__/ _` \\ \\ / / _ | |/ _ | '__|\n" +
                "  | | | | (_| |\\ V |  __| |  __| |   \n" +
                "  \\_|_|  \\__,_| \\_/ \\___|_|\\___|_|   \n");
        User user = new User();
        // TODO: Redundancy? How can we simplify this? We are passing escapeRoom into Itself.
        // Creating all of the rooms and loading the rooms with their data.
        EscapeRoom escapeRoom = new EscapeRoom();

        escapeRoom.generateEscapeRooms(escapeRoom);
        String name = EscapeRoom.prompt("Please enter your name: ", "[ a-zA-z]*",
                "\nThat is not a valid name!\n");
        user.newName(name);
        Traveler traveler = new Traveler(user, escapeRoom);
        traveler.menu();
    }

}
