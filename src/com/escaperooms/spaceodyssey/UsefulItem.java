package com.escaperooms.spaceodyssey;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UsefulItem {
    private String name;
    private List<String> dialogs;

    @JsonCreator
    public UsefulItem(@JsonProperty("name") String name, @JsonProperty("dialogs") List<String> dialogs) {
        this.name = name;
        this.dialogs = dialogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDialogs() {
        return dialogs;
    }

    public void setDialogs(List<String> dialogs) {
        this.dialogs = dialogs;
    }
}
