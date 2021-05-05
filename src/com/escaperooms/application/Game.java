package com.escaperooms.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class Game {
    @JsonProperty("name")
    public String name;
    @JsonProperty("rooms")
    public List<RoomV2> rooms;
    Game(){

    }

    Game(String name, List<RoomV2> rooms){
        this.name = name;
        this.rooms = rooms;
    }
    public List<RoomV2> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<RoomV2> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
