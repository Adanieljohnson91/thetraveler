package com.escaperooms.spaceodyssey;

import com.escaperooms.application.GameRoom;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

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
    private String actorRoomText;
    private String secretText;
    private List<TriviaV2> trivia;
    private boolean isAlive = true;


    @JsonCreator
    public ActorV2(@JsonProperty("name") String name,
                   @JsonProperty("actorRoomText") String actionRoomText,
                   @JsonProperty("secretText") String secretText,
                   @JsonProperty("dialogs") List<String> dialogs,
                   @JsonProperty("item") UsefulItem item,
                   @JsonProperty("trivia") List<TriviaV2> trivia) {
        this.name = name;
        this.dialogs = dialogs;
        this.item = item;
        this.trivia = trivia;
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
        String roomText = SpaceGame.CURRENT_ROOM.generateRoomText(false);
        UsefulItem item = giveItem();
        roomText += "\n\n" + dialogs.get(2);
        if (!item.getName().equals("none")){
            roomText += "\nYou have received " + item.getName();
        }
        SpaceGame.guiController.updateRoomText(roomText);
    }

    public void congratulateFight(){
        String roomText = SpaceGame.CURRENT_ROOM.generateRoomText(true);
        UsefulItem item = giveItem();
        roomText += "\n\n" + "That was close, Let's try to answer the question next time." + "\n\n" + secretText;
        if (!item.getName().equals("none")){
            roomText += "\nYou have received " + item.getName();
        }
        roomText += "\n\nInventory:\n" + GameRoom.user.getInventoryList();
        SpaceGame.guiController.updateRoomText(roomText);
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
            GameRoom.user.addItem(giveItem());
            isAlive = false;
            congratulate();
        }
    }

    private UsefulItem giveItem(){
        //System.out.println("You have received "+ this.item);
        return this.item;
    }

    private void questionDialog(){
        //System.out.println(dialogs.get(0));
        //String input = scanner.nextLine();
        String[] ansList = {"Fight","Answer"};
        List<String> answers = Arrays.asList(ansList);
        String input = SpaceGame.guiController.fightORQuestionDialog(dialogs.get(0),answers,getName());
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
        if(!isAlive)return;
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
        if(trivia.get(0).quizFight()){
            GameRoom.user.addItem(giveItem());
            congratulateFight();
            isAlive = false;
            return;
        }
        SpaceGame.guiController.triggerEndGame("GAME OVER", true);

    }
}
