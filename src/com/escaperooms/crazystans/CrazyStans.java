package com.escaperooms.crazystans;

import com.escaperooms.application.EscapeRoom;
import com.escaperooms.application.Playable;
import com.escaperooms.application.Traveler;
import com.escaperooms.application.User;
import com.escaperooms.music.MusicPlayer;

import java.io.IOException;

public class CrazyStans extends EscapeRoom {
    private final String name = "Crazy Stans";
    private Traveler traveler;
    private User user;
    private final Lobby lobby = new Lobby();
    private final BeyoncesRoom beyoncesRoom = new BeyoncesRoom();
    private final ArianasRoom arianasRoom = new ArianasRoom();
    private final MichaelJacksonsRoom michaelJacksonsRoom = new MichaelJacksonsRoom();
    private final ChristinaAguilerasRoom christinaAguilerasRoom = new ChristinaAguilerasRoom();
    private MusicPlayer musicPlayer;

    public CrazyStans() throws IOException {
    }

    @Override
    public void run(Traveler traveler, EscapeRoom escapeRoom) {
        musicPlayer = new MusicPlayer("stansbgm.wav");
        this.traveler = traveler;
        this.user = traveler.getUser();
        user.newName("Nick");
        opening();
        challenges();
        closing();
    }

    private void opening() {
        musicPlayer.start();
        System.out.println(welcomeMessage());
        EscapeRoom.prompt("Type 'start' to begin the challenges ", "start", "Invalid command");
        musicPlayer.stopMusic();
    }

    static String commandsList() {
        return "p = Play, s = Stop, r = Reset, quit = Quit";
    }

    private void challenges() {
        lobbyChallenge();
        if(user.getInventory().contains("match") || user.getInventory().contains("leaf headband")) {
            System.out.println("Beyonce is also a hidden leaf ninja, she has allowed you to skip her room and endowed you with one of her many grammys.");
            user.addItem("beyoncesGrammy");
        } else {
            beyonceChallenge();
        }
        arianaChallenge();
        michaelJacksonChallenge();
        christinaAguileraChallenge();
        System.out.println("You have escaped Crazy Stans!");
    }

    private void closing() {
        traveler.menu();
    }

    private void beyonceChallenge() {
        user.addItem(beyoncesRoom.start());
    }

    private void lobbyChallenge() {
        user.addItem(lobby.start());
    }

    private void arianaChallenge() {
        user.addItem(arianasRoom.start());
    }

    private void michaelJacksonChallenge() {
        user.addItem(michaelJacksonsRoom.start());
    }

    private void christinaAguileraChallenge() {
        user.addItem(christinaAguilerasRoom.start());
    }

    public String getName() {
        return this.name;
    }

    private String welcomeMessage() {
        return "Welcome to " + name + ". To escape this room, you will first have to solve the lobby challenge " +
                "and acquire the Song Key.\nThe Song Key will allow you to enter " +
                "Beyonce's, Ariana Grande's and Michael Jackson's rooms." +
                "\nIn each room, you must solve a challenge to acquire the room's item.\n" +
                "Once the items from those rooms have been collected, you can enter the final room of " +
                "Christina Aguilera." + "\nSolve all the challenges in the Aguilera room " +
                "to receive the mic of the great one.\nWith this mic, you will be able to make your escape.\n" +
                "If any of the challenges become too difficult along the way, type 'hint' to receive a hint.";
    }


    @Override
    public void terminate() {

    }

    @Override
    public Playable playable() throws IOException {
        return new Playable(this.getName(), welcomeMessage(), new CrazyStans());
    }
}
