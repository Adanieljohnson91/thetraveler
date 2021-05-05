package com.escaperooms.application;

import com.escaperooms.spaceodyssey.RoomV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Game {
    @JsonProperty("name")
    public String name;
    @JsonProperty("rooms")
    public List<RoomV2> rooms;

    @JsonCreator
    Game(@JsonProperty("name") String name, @JsonProperty("rooms") List<RoomV2> rooms){
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

    public void listRooms(){
        for(RoomV2 room: rooms){
            System.out.println(room.getName());
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
