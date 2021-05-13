package com.escaperooms.application;

import com.escaperooms.spaceodyssey.UsefulItem;

import java.util.ArrayList;
import java.util.List;

public class UserV2 {

    private List<UsefulItem> items = new ArrayList<>();

    public UserV2(){
        /**
         *We are adding this item by default to work with the room locking mechanisms. this should be
         * refactored, will require massaging of the data.
         * *

         */
        items.add(new UsefulItem("none", ""));
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
            list.add(item.getName());
        }
        return String.join(", ",list);
    }

    public List<UsefulItem> getInventoryItems(){
        return items;
    }

}
