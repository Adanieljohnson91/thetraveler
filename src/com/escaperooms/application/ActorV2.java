package com.escaperooms.application;

import java.util.ArrayList;
import java.util.List;

public class ActorV2 {
    private String name;
    private List<String> dialogs;
    private Item item;
    private List<TriviaV2> trivia;

    ActorV2(){

    }

    public ActorV2(String name, List<String> dialogs, Item item, List<TriviaV2> trivia) {
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
