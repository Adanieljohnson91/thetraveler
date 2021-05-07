package com.escaperooms.spaceodyssey;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * "name": "Big Daddy the Devilishly Handsome Donkey",
 *               "health": 5,
 *               "attack": 1,
 *               "actorRoomText": "Flames light up against the wall, toward the back of the room sits a Donkey on a suede Throne his snout buried in a bucket full of mice, you can hear their little squeeks as their bones pop between the donkeys bloody teeth",
 *               "secretText": "Oh, no, how could this be, Big Daddy was taken down by someone like you... ",
 *               "dialogs": [
 *                 "Hey hey hey, [Big Daddy stairs at your jacket], That's a nice jacket you have there, can I try it on? ",
 *                 "They call me Big Daddy for a reason, I guess its time to tumble.... HeeHaw",
 *                 "HeeHaw"
 *               ],
 *               "item":
 *               {
 *                 "name": "Pioneer 8 Track Stereo Model H-R99",
 *                 "inscription": "cool cats never die, the have many lives."
 *               },
 */
public class ActorV2 {
    private String name;
    private List<String> dialogs;
    private UsefulItem item;
    private List<UsefulItem> wantedItem;
    private int health;
    private int attack;
    private String actorRoomText;
    private String secretText;
    private List<TriviaV2> trivia;
    private boolean questionAnswered;


    @JsonCreator
    public ActorV2(@JsonProperty("name") String name,
                   @JsonProperty("health") int health,
                   @JsonProperty("attack") int attack,
                   @JsonProperty("actorRoomText") String actionRoomText,
                   @JsonProperty("secretText") String secretText,
                   @JsonProperty("dialogs") List<String> dialogs,
                   @JsonProperty("item") UsefulItem item,
                   @JsonProperty("trivia") List<TriviaV2> trivia,
                   @JsonProperty("wantedItem") List<UsefulItem> wantedItem) {
        this.name = name;
        this.dialogs = dialogs;
        this.item = item;
        this.trivia = trivia;
        this.wantedItem = wantedItem;
        this.health = health;
        this.attack = attack;
        this.actorRoomText = actionRoomText;
        this.secretText = secretText;

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

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public String getActorRoomText() {
        return actorRoomText;
    }

    public String getSecretText() {
        return secretText;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActorRoomText(String actorRoomText) {
        this.actorRoomText = actorRoomText;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setQuestionAnswered(boolean questionAnswered) {
        this.questionAnswered = questionAnswered;
    }

    public void setSecretText(String secretText) {
        this.secretText = secretText;
    }

    public void setWantedItem(List<UsefulItem> wantedItem) {
        this.wantedItem = wantedItem;
    }

    public void describe(){
        System.out.println(dialogs.get(0));
    }

    public void congratulate(){
        System.out.println(dialogs.get(1));
    }

    private boolean doesActorHaveItem(){
        return wantedItem.isEmpty();
    }

    public void interact(){
        /**
         * when you interact with an Actor, we will need to check if we currently have an item they
         * are looking for, if not then option1 is called if yes option2 is called
         */
        if(GameRoom.user.hasItem(item)){
            option2();
        }else{
            askQuestion();
        }
    }

    private void askQuestion(){
        if(trivia.get(0).quiz()){
            congratulate();
            GameRoom.user.addItem(giveItem());
        }
    }

    private UsefulItem giveItem(){
        System.out.println("You have received "+ this.item);
        return this.item;
    }

    private void option1(){
        System.out.println(dialogs.get(1));
    }
    private void option2(){
        System.out.println(dialogs.get(2));
    }
}
