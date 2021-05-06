package com.escaperooms.application;

import com.escaperooms.spaceodyssey.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameRoom {

    private List<Game> games;
    private Map<String, Game> gameMap = new HashMap<>();
    private Game currentGame;
    public static UserV2 user;
    Scanner scanner = new Scanner(System.in);

    public GameRoom(List<Game> games, UserV2 user){
        this.user = user;
        this.games = games;
        buildGameMap();
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game){
        gameMap.put(game.getName(), game);
    }

    public void play(){
        System.out.println("Select a Game");
        listGames();
        while (true){
            String input = scanner.nextLine();
            currentGame = gameMap.get(input);
            currentGame.play();
        }

    }

    private void buildGameMap(){
        for(Game game: games){
            gameMap.put(game.getName(), game);
        }
    }

    private void setCurrentGame(SpaceGame game){
        this.currentGame = game;
    }

    public void listGames(){
        for(String game: gameMap.keySet()){
            System.out.println(game);
        }
    }

    public void setGames(List<SpaceGame> game) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GameRoom{" +
                "games=" + games +
                '}';
    }
}
