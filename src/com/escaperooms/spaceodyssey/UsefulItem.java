package com.escaperooms.spaceodyssey;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UsefulItem {
    private String name;
    private String inscription;

    @JsonCreator
    public UsefulItem(@JsonProperty("name") String name, @JsonProperty("inscription") String inscription) {
        this.name = name;
        this.inscription = inscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialogs() {
        return inscription;
    }

    public void setDialogs(String inscription) {
        this.inscription = inscription;
    }
}
