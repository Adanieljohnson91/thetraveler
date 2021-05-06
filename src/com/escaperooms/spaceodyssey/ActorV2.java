package com.escaperooms.spaceodyssey;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActorV2 {
    private String name;
    private List<String> dialogs;
    private UsefulItem item;
    private List<UsefulItem> wantedItem;
    private List<TriviaV2> trivia;

    ActorV2(){

    }

    @JsonCreator
    public ActorV2(@JsonProperty("name") String name,
                   @JsonProperty("dialogs") List<String> dialogs,
                   @JsonProperty("item") UsefulItem item,
                   @JsonProperty("trivia") List<TriviaV2> trivia,
                   @JsonProperty("wantedItem") List<UsefulItem> wantedItem) {
        this.name = name;
        this.dialogs = dialogs;
        this.item = item;
        this.trivia = trivia;
        this.wantedItem = wantedItem;

    }

    public String getName() {
        return name;
    }

    public List<String> getDialogs() {
        return dialogs;
    }

    public UsefulItem getItem() {
        return item;
    }

    public List<TriviaV2> getTrivia() {
        return trivia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDialogs(List<String> dialogs) {
        this.dialogs = dialogs;
    }

    public void setItem(UsefulItem item) {
        this.item = item;
    }

    public void setTrivia(List<TriviaV2> trivia) {
        this.trivia = trivia;
    }

    public void interact(){
        /**
         * when you interact with an Actor, we will need to check if we currently have an item they
         * are looking for, if not then option1 is called if yes option2 is called
         */
        if(GameRoom.user.hasItem(wantedItem)){
            option2();
        }else{
            option1();
        }
    }

    private void option1(){
        System.out.println(dialogs.get(1));
    }
    private void option2(){
        System.out.println(dialogs.get(2));
    }
}
