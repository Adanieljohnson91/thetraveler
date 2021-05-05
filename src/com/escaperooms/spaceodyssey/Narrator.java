package com.escaperooms.spaceodyssey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Narrator {
    Map<String, String> spaceDetails;
    Map<String, String> chefDetails;
    Map<String, String> ninjaDetails;
    Map<String, String> crazyDetails;
   Narrator() throws IOException {
       setSpaceDetails(new HashMap<>());
       setCrazyDetails(new HashMap<>());
       setNinjaDetails(new HashMap<>());
       try {
           InputStream in = getClass().getResourceAsStream("/resources/data/Descriptions.csv");
           BufferedReader reader = new BufferedReader(new InputStreamReader(in));
           reader.lines().forEach(roomData -> {
               String[] descriptionCells = roomData.split(" : ");
               switch (descriptionCells[0]){
                   case "Space Odyssey" : spaceDetails.put(descriptionCells[1],descriptionCells[2]); break;
                   case "Jonin Exam" : ninjaDetails.put(descriptionCells[1],descriptionCells[2]); break;
                   case "Crazy Stan" : crazyDetails.put(descriptionCells[1],descriptionCells[2]); break;
                   case "Kitchen Clean-up" : chefDetails.put(descriptionCells[1],descriptionCells[2]); break;
               }
           });
       } catch(Exception e) {
           System.out.println(e);
       }
   }

    public void setSpaceDetails(Map<String, String> spaceDetails) {
        this.spaceDetails = spaceDetails;
    }

    public void setNinjaDetails(Map<String, String> ninjaDetails) {
        this.ninjaDetails = ninjaDetails;
    }

    public void setCrazyDetails(Map<String, String> crazyDetails) {
        this.crazyDetails = crazyDetails;
    }

    public Map<String, String> getSpaceDetails() {
        return spaceDetails;
    }

    public Map<String, String> getNinjaDetails() {
        return this.ninjaDetails;
    }

    public Map<String, String> getCrazyDetails() {
        return this.crazyDetails;
    }

    public void spaceTalk (String item){
            System.out.println(spaceDetails.getOrDefault(item, "I don't know that word: " + item));
    }
    public void spaceTalk (String item, int next){
        try{
            System.out.println(spaceDetails.get(item).split(" ~ ")[next]);
        }catch(Exception e){
            System.out.println(item+"#"+next+" not found");
        }
    }

    public void chefTalk (String item){
        try{
            System.out.println(chefDetails.getOrDefault(item, "I don't know that word: " + item));
        }catch(Exception e){
            System.out.println(item +"not found");
        }
    }
    public void chefTalk (String item, int next){
        try{
            System.out.println(chefDetails.get(item).split(" ~ ")[next]);
        }catch(Exception e){
            System.out.println(item+"#"+next+" not found");
        }
    }

    public void crazyTalk (String item){
        try{
            System.out.println(crazyDetails.getOrDefault(item, "I don't know that word: " + item));
        }catch(Exception e){
            System.out.println(item +"not found");
        }
    }
    public void crazyTalk (String item, int next){
        try{
            System.out.println(crazyDetails.get(item).split(" ~ ")[next]);
        }catch(Exception e){
            System.out.println(item+"#"+next+" not found");
        }
    }

    public void ninjaTalk (String item){
        try{
            System.out.println(ninjaDetails.getOrDefault(item, "I don't know that word: " + item));
        }catch(Exception e){
            System.out.println(item +"not found");
        }
    }
    public void ninjaTalk (String item, int next){
        try{
            System.out.println(ninjaDetails.get(item).split(" ~ ")[next]);
        }catch(Exception e){
            System.out.println(item+"#"+next+" not found");
        }
    }


}