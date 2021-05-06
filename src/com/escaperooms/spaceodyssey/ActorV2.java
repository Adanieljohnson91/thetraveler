package com.escaperooms.spaceodyssey;

import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActorV2 {
    private String name;
    private List<String> dialogs;
    private Item item;
    private List<TriviaV2> trivia;

    ActorV2(){

    }

    @JsonCreator
    public ActorV2(@JsonProperty("name") String name,
                   @JsonProperty("dialogs") List<String> dialogs,
                   @JsonProperty("item") Item item,
                   @JsonProperty("trivia") List<TriviaV2> trivia) {
        this.name = name;
        this.dialogs = dialogs;
        this.item = item;
        this.trivia = trivia;

    }

    public String getName() {
        return name;
    }

    public List<String> getDialogs() {
        return dialogs;
    }

    public Item getItem() {
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

    public void setItem(Item item) {
        this.item = item;
    }

    public void setTrivia(List<TriviaV2> trivia) {
        this.trivia = trivia;
    }
}
