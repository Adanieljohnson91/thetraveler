package com.escaperooms.joninexams;

import com.escaperooms.application.Game;
import com.escaperooms.spaceodyssey.RoomV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JoninGame implements Game {

    @JsonProperty("name")
    public String name;

    @JsonProperty("villages")
    private List<Village> villages;

    @JsonProperty("fighters")
    private List<Fighter>fighters;

    @JsonCreator
    public JoninGame(@JsonProperty("name") String name,
                     @JsonProperty("villages") List<Village>villages,
                     @JsonProperty("fighters") List<Fighter>fighters){
        this.name = name;
        this.fighters =fighters;
        this.villages=villages;
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.println("\nPlaying Jonin Game");
    }
}
