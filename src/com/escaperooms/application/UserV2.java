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
        /*
        System.out.println("Before we begin, What should we call you? ");
        name = scanner.nextLine().trim();
        System.out.println("Welcome " + name + " Are you ready for an Adventure of a lifetime?");

         */
        List<String> s = new ArrayList<>();
        items.add(new UsefulItem("none", ""));
    }

    /**
     * Will need to think out logic more, Dog checks for multiple items... may need to do check for it wanted list
     * contains more than one item, or not.
     *
     * Will
     * @param items
     * @return
     */
    public boolean hasItem(List<UsefulItem> items){
        boolean res = false;
        for(UsefulItem i : items){
            for(UsefulItem j: this.items){
                if(i.getName().equalsIgnoreCase(j.getName())){
                    res = true;
                }
            }
        }
        return res;
    }
    public boolean hasItem(UsefulItem item){
        boolean res = false;
        for(UsefulItem i: items){
            if(item.getName().equalsIgnoreCase(i.getName())){
                res = true;
                break;
            }
        }
        return res;
    }

    public void addItem(UsefulItem item){
        items.add(item);
    }

    public String getInventoryList(){
        List<String> list = new ArrayList<>();
        for (UsefulItem item : items){
            if (!item.getName().equalsIgnoreCase("none")) list.add(item.getName());
        }
        return String.join(", ", list);
    }

    public List<UsefulItem> getInventoryItems(){
        return items;
    }

}
