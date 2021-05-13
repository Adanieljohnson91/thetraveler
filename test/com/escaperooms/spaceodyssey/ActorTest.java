package com.escaperooms.spaceodyssey;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;
import com.escaperooms.application.GameRoom;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import java.util.List;

public class ActorTest {

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

    @Before
    public void setUp() {
        List<UsefulItem> wantedItem = List.of(item1, item2);
        TriviaV2 trivia1 = new TriviaV2(question1, answers1, correctAnswer1);
        TriviaV2 trivia2 = new TriviaV2(question2, answers2, correctAnswer2);
        List<TriviaV2> trivia = List.of(trivia1, trivia2);
        actor = new ActorV2(name, health, attack, actorRoomText, secretText, dialogs, item1, trivia, wantedItem);
    }

    @Test
    public void IsAliveTest() {
        assertEquals(true, actor.getIsAlive());
    }

    @Test
    public void questionDialogTest() {
        assertEquals("Hello", dialogs.get(0));
    }

    @Test
    public void getActorRoomTest(){
        assertEquals("Welcome to my room", actor.getActorRoomText());
    }

    @Test
    public void getBattleDialogTest(){
        assertEquals("How are you?", actor.getBattleDialog());
    }

}
