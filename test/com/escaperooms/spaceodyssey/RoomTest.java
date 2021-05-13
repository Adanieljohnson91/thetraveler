package com.escaperooms.spaceodyssey;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomTest {
    private String roomName = "kitchen";
    private String roomDescription = "This is where food is made";
    private List<String> adjacent_rooms = List.of("living room", "bloody bath", "falling balcony");
    private UsefulItem requiredItem = new UsefulItem("iphone 12 pro", "made in China");

    private String name = "Jason";
    private List<String> dialogs = List.of("Hello", "How are you?");
    private UsefulItem item1 = new UsefulItem("knife", "it will kill you");
    private UsefulItem item2 = new UsefulItem("sword", "it will chop you");
    private int health = 20;
    private int attack = 5;
    private String actorRoomText = "Welcome to my room";
    private String secretText = "Secretto Italiano";

    private String question1 = "What color is the sky?";
    private List<String> answers1 = List.of("white", "blue", "red", "black");
    private String correctAnswer1 = "blue";

    private String question2 = "Amazon HQ City?";
    private List<String> answers2 = List.of("Vancouver", "NYC", "Seattle", "London");
    private String correctAnswer2 = "Seattle";

    private boolean isAlive = true;
    private boolean questionAnswered;
    ActorV2 actor;
    RoomV2 room;

    @Before
    public void setUp() {
        List<UsefulItem> wantedItem = List.of(item1, item2);
        TriviaV2 trivia1 = new TriviaV2(question1, answers1, correctAnswer1);
        TriviaV2 trivia2 = new TriviaV2(question2, answers2, correctAnswer2);
        List<TriviaV2> trivia = List.of(trivia1, trivia2);
        actor = new ActorV2(name, health, attack, actorRoomText, secretText, dialogs, item1, trivia, wantedItem);
        room = new RoomV2(roomName, roomDescription, requiredItem, actor, adjacent_rooms);
    }

    @Test
    public void getAdjacentRoomsTest() {
        assertEquals(List.of("living room", "bloody bath", "falling balcony"), room.getAdjacent_rooms());
    }

    @Test
    public void getNameTest() {
        assertEquals("kitchen", room.getName());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("This is where food is made", room.getDescription());
    }

    @Test
    public void getActorTest() {
        assertEquals(actor, room.getActor());
    }

    @Test
    public void getRequiredItemTest(){
        assertEquals(requiredItem, room.getRequiredItem());
    }

}
