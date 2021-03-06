package com.escaperooms.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageLoader {
    private HashMap<String, ImageIcon> imageIcons;

    public ImageLoader() {
        imageIcons = new HashMap<>();
        String[] animals = {"duck", "bunny", "bat", "alligator", "bear", "cat", "donkey"};
        String[] types = {"general", "quiz", "fight"};
        // generate animal icons
        for (String animal : animals){
            for (String type : types){
                String key = animal + "_" + type;
                String imagePath = "data/images/" + key + ".png";
                Image img = null;
                try{
                    img = ImageIO.read(new File(imagePath));
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
                img = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
                imageIcons.put(key,new ImageIcon(img));
            }
        }
        // create win icon
        Image img = null;
        String imagePath = "data/images/win.jpg";
        try{
            img = ImageIO.read(new File(imagePath));
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        img = img.getScaledInstance(750,525,Image.SCALE_SMOOTH);
        imageIcons.put("win",new ImageIcon(img));
        // create loss icon
        imagePath = "data/images/lose.jpg";
        try{
            img = ImageIO.read(new File(imagePath));
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        img = img.getScaledInstance(750,525,Image.SCALE_SMOOTH);
        imageIcons.put("lose",new ImageIcon(img));
        //create opening icon
        imagePath = "data/images/hallway.jpg";
        try{
            img = ImageIO.read(new File(imagePath));
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        img = img.getScaledInstance(750,525,Image.SCALE_SMOOTH);
        imageIcons.put("opening",new ImageIcon(img));
    }

    public ImageIcon getImage(String key){
        return imageIcons.get(key);
    }
}
