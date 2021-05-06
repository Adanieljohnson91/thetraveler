package com.escaperooms.joninexams;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Village {
    private String name;
    private String intro;

    @JsonCreator
    public Village(@JsonProperty("name") String name, @JsonProperty("intro") String intro){
        this.name = name;
        this.intro = intro;
    }

}
