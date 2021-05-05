package com.escaperooms.application;

import com.escaperooms.spaceodyssey.RoomV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Game {
    @JsonProperty("name")
    public String name;
    @JsonProperty("rooms")
    public List<RoomV2> rooms;
    /**
     * @param roomMap is used to store our rooms so that we can navigate our game. inside of the roomMap are rooms orgainzed by name
     *                each room has a list of adjacent rooms they can connect to, we will use those names to switch the room we are currently in.
     */
    private Map<String, RoomV2> roomMap = new HashMap<>();
    private RoomV2 currentRoom;

    @JsonCreator
    Game(@JsonProperty("name") String name, @JsonProperty("rooms") List<RoomV2> rooms){
        this.name = name;
        this.rooms = rooms;
        createRoomMap();
        currentRoom = roomMap.get("kitchen");
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

    private void createRoomMap(){
        for(RoomV2 room: rooms){
            roomMap.put(room.getName(), room);
        }
    }

    public void listRooms(){
        for(RoomV2 room: rooms){
            System.out.println(room.getName());
        }
    }

    public RoomV2 getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
