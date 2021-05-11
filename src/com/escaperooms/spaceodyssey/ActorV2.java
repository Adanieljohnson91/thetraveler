package com.escaperooms.spaceodyssey;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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

    Scanner scanner = new Scanner(System.in);

    private String name;
    private List<String> dialogs;
    private UsefulItem item;
    private List<UsefulItem> wantedItem;
    private int health;
    private int attack;
    private String actorRoomText;
    private String secretText;
    private List<TriviaV2> trivia;
    private boolean isAlive = true;
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

    public UsefulItem getItem() {
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setItem(UsefulItem item) {
        this.item = item;
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
        if(!isAlive)return;
        questionDialog();
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

    private void questionDialog(){
        System.out.println(dialogs.get(0));
        String input = scanner.nextLine();
        /**
         * expect available commands; if they are not valid ask again
         */
        battleOrAnswerQuestion(input);


    }

    private void battleOrAnswerQuestion(String string){
        switch (string.toUpperCase(Locale.ROOT)){
            case "FIGHT":
                battleDialog();
                break;
            case "ANSWER":
                askQuestion();
                break;
            case "LEAVE":
                break;
            default:
                System.out.println("AVAILABLE OPTIONS: FIGHT, ANSWER, LEAVE");
                questionDialog();
        }

    }

    public void sceneDialog(){
        System.out.println(actorRoomText);
    }


    public String getActorRoomText(){
        return actorRoomText;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void battleDialog(){
        System.out.println(dialogs.get(1));
    }

    public String getBattleDialog(){
        return dialogs.get(1);
    }

    public void noiseDialog(){
        System.out.println(dialogs.get(2));
    }

    public String getNoiseDialog() {
        return dialogs.get(2);
    }

    public void defeatDialog(){
        System.out.println(secretText);
    }

    public String getDefeatDialog() {
        return secretText;
    }
}
