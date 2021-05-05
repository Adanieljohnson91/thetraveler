package com.escaperooms.client;

import java.util.List;

public class Delete {
    public String name;
    public String age;
    public List<String> location;


    public String getName() {
        return name;
    }

    public List<String> getLocation() {
        return location;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }
}
