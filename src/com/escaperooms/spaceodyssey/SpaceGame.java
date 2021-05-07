package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Game;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SpaceGame implements Game {

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    public String name;

    @JsonProperty("rooms")
    private List<RoomV2> rooms;

    private final SpaceController controller = new SpaceController();
    private final Scanner scanner = new Scanner(System.in);
    /**
     * @param roomMap is used to store our rooms so that we can navigate our game. inside of the roomMap are rooms orgainzed by name
     *                each room has a list of adjacent rooms they can connect to, we will use those names to switch the room we are currently in.
     */
    public static Map<String, RoomV2> ROOMMAP = new HashMap<>();
    public static RoomV2 CURRENT_ROOM;

    @JsonCreator
    public SpaceGame(@JsonProperty("name") String name, @JsonProperty("rooms") List<RoomV2> rooms){
        this.name = name;
        createRoomMap(rooms);
        CURRENT_ROOM = ROOMMAP.get("kitchen");
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

    private void createRoomMap(List<RoomV2> rooms){
        for(RoomV2 room: rooms){
            ROOMMAP.put(room.getName(), room);
        }
    }
    /**
     * Game logic: a user starts in a room and is given a description of the area
     * based on the room they will have different options on how to interact
     * common commands are [GO, TALK]... should rooms have a List of commands in string format
     * we loop over that string and pull out the available commands that match a larger Commands Enum?
     */
    public void play(){

        try{
            while (true){
                currentSceneDialogs();
                String input = scanner.nextLine();
                controller.control(input);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void currentSceneDialogs(){
        try{
            System.out.println(CURRENT_ROOM.getDescription());
            CURRENT_ROOM.getActor().describe();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public RoomV2 getCurrentRoom() {
        return CURRENT_ROOM;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
