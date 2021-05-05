package com.escaperooms.application;

import java.util.ArrayList;
import java.util.List;

public class UsefulItem {
    private String name;
    private List<String> dialogs = new ArrayList<>();

    UsefulItem(){

    }

    public UsefulItem(String name, List<String> dialogs) {
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
