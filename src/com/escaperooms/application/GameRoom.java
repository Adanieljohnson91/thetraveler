package com.escaperooms.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class GameRoom {

    private List<Game> games;

    @JsonCreator
    GameRoom(@JsonProperty("games") List<Game> games){
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }

    public void listRooms(){
        for(Game game: games){
            System.out.println(game.getName());
        }
    }

    public void setGames(List<Game> game) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GameRoom{" +
                "games=" + games +
                '}';
    }
}
