package com.escaperooms.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoomV2 {
    private String name;
    private String description;
    private List<UsefulItem> usefulItem;
    private ActorV2 actor;
    private List<String> adjacent_rooms;

    RoomV2(){

    }
    @JsonCreator
    public RoomV2(@JsonProperty("name")String name,
                  @JsonProperty("description")String description,
                  @JsonProperty("usefulItem")List<UsefulItem> usefulItem,
                  @JsonProperty("actor")ActorV2 actor,
                  @JsonProperty("adjacent_rooms")List<String> adjacent_rooms) {
        this.name = name;
        this.description = description;
        this.usefulItem = usefulItem;
        this.actor = actor;
        this.adjacent_rooms = adjacent_rooms;
    }

    public String getName() {
        return name;
    }

    public List<String> getAdjacent_rooms() {
        return adjacent_rooms;
    }

    public void setAdjacent_rooms(List<String> adjacent_rooms) {
        this.adjacent_rooms = adjacent_rooms;
    }

    public ActorV2 getActor() {
        return actor;
    }

    public String getDescription() {
        return description;
    }

    public List<UsefulItem> getUsefulItem() {
        return usefulItem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActor(ActorV2 actor) {
        this.actor = actor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsefulItem(List<UsefulItem> usefulItem) {
        this.usefulItem = usefulItem;
    }

}
