package com.escaperooms.application;

public interface Controller {
    /**
     *
     * @param input
     * controller will take in inputs and use the inputs to perform operations based on the Games Command Enum
     */
    void control(String input);
}
