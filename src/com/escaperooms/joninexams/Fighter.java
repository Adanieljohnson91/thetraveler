package com.escaperooms.joninexams;
import com.escaperooms.application.Item;
import com.escaperooms.spaceodyssey.TriviaV2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.PublicKey;
import java.util.List;

public class Fighter {
    private String name;
    private Integer ninjaHP;
    private String intro;
    private List<Attack> attacks;
    private String question;

    Fighter(){

    }

    @JsonCreator
    public Fighter(@JsonProperty("name") String name,
                   @JsonProperty("ninjaHP") Integer ninjaHP,
                   @JsonProperty("intro") String intro,
                   @JsonProperty("attacks") List<Attack> attacks,
                   @JsonProperty("question") String question) {
        this.name = name;
        this.ninjaHP = ninjaHP;
        this.intro = intro;
        this.attacks = attacks;
        this.question = question;
    }

    public String getName() {return name;}
    public String getIntro() {return intro;}
    public Integer getNinjaHp() {return ninjaHP;}
    public List<Attack> getAttacks(){return attacks;}
    public void setName(String name) {
        this.name = name;
    }
    public void setIntro(String intro) {this.intro = intro;}
    public void seHP(Integer hp) {this.ninjaHP = hp;}
    public void setAttacks(List<Attack> attacks) {this.attacks = attacks;}

}
