package com.escaperooms.gui;

import com.escaperooms.gui.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameInterface extends JFrame {
    private final int FRAME_X_SIZE = 800;
    private final int FRAME_Y_SIZE = 600;

    private JTextArea roomTextTA;
    private JTextField playerInputTF;
    private JButton submitBTN;
    private Controller controller;

    private ImageLoader imageLoader;

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

        playerInputTF = new JTextField();
        playerInputTF.setBounds(25, 325, 250,25);
        playerInputTF.addActionListener(new HandleEnterPressOnPlayerInputTF());

        submitBTN = new JButton("Submit");
        submitBTN.setBounds(275,325,100,25);
        submitBTN.addActionListener(new HandleSubmitBTNClick());

        add(roomTextTA);
        add(playerInputTF);
        add(submitBTN);

        imageLoader = new ImageLoader();

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
