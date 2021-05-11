package com.escaperooms.gui;

import com.escaperooms.gui.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInterface extends JFrame {
    private final int FRAME_X_SIZE = 800;
    private final int FRAME_Y_SIZE = 600;

    private JTextArea roomTextTA;
    private JTextField playerInputTF;
    private JButton submitBTN;
    Controller controller;

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

        playerInputTF = new JTextField();
        playerInputTF.setBounds(25, 325, 250,25);
        playerInputTF.addActionListener(new HandleEnterPressOnPlayerInputTF());

        submitBTN = new JButton("Submit");
        submitBTN.setBounds(275,325,100,25);
        submitBTN.addActionListener(new HandleSubmitBTNClick());

        add(roomTextTA);
        add(playerInputTF);
        add(submitBTN);

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
}
