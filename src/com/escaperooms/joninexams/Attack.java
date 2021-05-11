package com.escaperooms.joninexams;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Attack {
    private String name;
    private String text;

    @JsonCreator
    public Attack(@JsonProperty("name") String name, @JsonProperty("text") String text){
        this.name = name;
        this.text = text;
    }
}
