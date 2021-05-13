package com.escaperooms.spaceodyssey;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoomV2 {
    private String name;
    private String description;
    private UsefulItem requiredItem;
    private ActorV2 actor;
    private List<String> adjacent_rooms;
    private String song;

    @JsonCreator
    public RoomV2(@JsonProperty("name")String name,
                  @JsonProperty("description")String description,
                  @JsonProperty("requiredItem")UsefulItem requiredItem,
                  @JsonProperty("actor")ActorV2 actor,
                  @JsonProperty("adjacent_rooms")List<String> adjacent_rooms,
                  @JsonProperty("song") String song) {
        this.name = name;
        this.description = description;
        this.requiredItem = requiredItem;
        this.actor = actor;
        this.adjacent_rooms = adjacent_rooms;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public String getSong() {
        return song;
    }

    public List<String> getAdjacent_rooms() {
        return adjacent_rooms;
    }

    public UsefulItem getRequiredItem() {
        return requiredItem;
    }

    public ActorV2 getActor() {
        return actor;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateRoomText(boolean showRooms){
        String roomText = "Room Name: " + SpaceGame.CURRENT_ROOM.getName();
        roomText += "\n\n" + SpaceGame.CURRENT_ROOM.getDescription();
        if (SpaceGame.CURRENT_ROOM.getActor().getIsAlive()){
            roomText += "\n\n" + SpaceGame.CURRENT_ROOM.getActor().getActorRoomText();
        }else{
            roomText += "\n\nIt seems to be peaceful in here... " +
                    "We should check some more rooms...";
        }
        if (showRooms) {
            roomText +=   String.join(", ", SpaceGame.CURRENT_ROOM.getAdjacent_rooms());
        }
        return roomText;
    }

}
