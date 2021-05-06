package com.escaperooms.application;

import com.escaperooms.spaceodyssey.UsefulItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserV2 {
    private String name;
    private List<UsefulItem> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public UserV2(){
        name = scanner.nextLine().trim();
        System.out.println("Welcome " + name);
    }

}
