package com.escaperooms.application;

import com.escaperooms.spaceodyssey.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameRoom {

    private List<SpaceGame> games;
    private Map<String, Game> gameMap = new HashMap<>();
    private Game currentGame;
    Scanner scanner = new Scanner(System.in);

    @JsonCreator
    GameRoom(@JsonProperty("games") List<SpaceGame> games){
        this.games = games;
        buildGameMap();
    }

    public List<SpaceGame> getGames() {
        return games;
    }

    public void addGame(Game game){
        gameMap.put(game.getName(), game);
    }

    public void play(){
        listGames();
        while (true){
            System.out.println("Select a Game");
            String input = scanner.nextLine();
            currentGame = gameMap.get(input);
            currentGame.play();
        }

    }

    private void buildGameMap(){
        for(SpaceGame game: games){
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
