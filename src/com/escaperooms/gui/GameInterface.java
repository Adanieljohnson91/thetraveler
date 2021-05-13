package com.escaperooms.gui;

import com.escaperooms.gui.controller.Controller;
import com.escaperooms.music.MusicPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GameInterface extends JFrame {
    private final int FRAME_X_SIZE = 800;
    private final int FRAME_Y_SIZE = 600;


    private JTextArea roomTextTA;
    private JTextField playerInputTF;
    private JButton submitBTN;
    private Controller controller;

    private ImageLoader imageLoader;
    private JButton openingSceneBTN;

    public GameInterface(String title){
        super(title);

        setLocation(100,100);
        setSize(FRAME_X_SIZE,FRAME_Y_SIZE);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        roomTextTA = new JTextArea();
        roomTextTA.setText("The is the room text area.");
        roomTextTA.setBounds(25,25,getWidth() - (25 + 25),300);
        roomTextTA.setLineWrap(true);
        roomTextTA.setWrapStyleWord(true);
        roomTextTA.setEditable(false);
        roomTextTA.setVisible(false);

        playerInputTF = new JTextField();
        playerInputTF.setBounds(25, 350, 625,25);
        playerInputTF.addActionListener(new HandleEnterPressOnPlayerInputTF());
        playerInputTF.setVisible(false);

        submitBTN = new JButton("Submit");
        submitBTN.setBounds(675,350,100,25);
        submitBTN.addActionListener(new HandleSubmitBTNClick());
        submitBTN.setVisible(false);

        openingSceneBTN = new JButton();
        openingSceneBTN.setBounds(25,25,750,525);
        openingSceneBTN.addActionListener(new HandleOpeningSceneBTNClick());
        openingSceneBTN.setVisible(false);
        Image img = null;
        try{
            img = ImageIO.read(new File("data/images/hallway.jpg"));
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        img = img.getScaledInstance(750,525,Image.SCALE_SMOOTH);
        openingSceneBTN.setIcon(new ImageIcon(img));

        add(roomTextTA);
        add(playerInputTF);
        add(submitBTN);
        add(openingSceneBTN);
        imageLoader = new ImageLoader();
        showOpeningScene();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void submitInput(){
        String input = playerInputTF.getText();
        if (!input.isEmpty()){
            controller.submitUserInput(input);
            playerInputTF.setText("");
        }
    }

    public void setRoomTextTA(String roomText){
        roomTextTA.setText(roomText);
    }

    public String twoAnswerDialog(String question, List<String> answers, String iconKey){
        Object[] options = new Object[2];
        options[0] = answers.get(0);
        options[1] = answers.get(1);
        int result = JOptionPane.showOptionDialog(this,
                question,
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                imageLoader.getImage(iconKey),
                options,
                null);
        //System.out.println(result);
        if (result != -1) {
            return answers.get(result);
        }
        return "";
    }

    public String triviaDialog(String question, List<String> answers,String key){
        int answerCount = answers.size();
        Object[] options = new Object[answerCount];
        for (int x=0; x < answerCount; x++){
            options[x] = answers.get(x);
        }
        int result = JOptionPane.showOptionDialog(this,
                question,
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                imageLoader.getImage(key),
                options,
                null);
        if (result != -1) {
            return answers.get(result);
        }
        return "";
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this,
                message);
    }

    public String fightDialog(String question, List<String> answers){
        int answerCount = answers.size();
        Object[] options = new Object[answerCount];
        for (int x=0; x < answerCount; x++){
            options[x] = answers.get(x);
        }
        int result = JOptionPane.showOptionDialog(this,
                question,
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
        System.out.println(result);
        if (result != -1) {
            System.out.println(answers.get(result));
            return answers.get(result);
        }
        return "";
    }

    public int gameOver(String message, boolean success){
        Object[] options = {"Restart", "Exit Game"};
        int n = JOptionPane.showOptionDialog(
                this,
                message,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                success ? imageLoader.getImage("freedom") : imageLoader.getImage("skull"),
                options,
                null
        );
        return n;
    }

    public void showOpeningScene(){
        roomTextTA.setVisible(false);
        playerInputTF.setVisible(false);
        submitBTN.setVisible(false);
        openingSceneBTN.setVisible(true);
    }

    public void showGame(){
        roomTextTA.setVisible(!false);
        playerInputTF.setVisible(!false);
        submitBTN.setVisible(!false);
        openingSceneBTN.setVisible(!true);
    }

    private class HandleSubmitBTNClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("submitBTN clicked");
            submitInput();
        }
    }

    private class HandleEnterPressOnPlayerInputTF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Enter pressed in the text field");
            submitInput();
        }
    }

    private class HandleOpeningSceneBTNClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showGame();
        }
    }
}
