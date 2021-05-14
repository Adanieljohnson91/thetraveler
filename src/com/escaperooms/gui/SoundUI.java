package com.escaperooms.gui;

import com.escaperooms.music.MusicPlayer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SoundUI extends JFrame{
    private final int FRAME_X_SIZE = 230;
    private final int FRAME_Y_SIZE = 250;

    private JLabel BGMLbl;
    private JSlider BGMVolSlider;

    private MusicPlayer mp;

    public SoundUI(String title, MusicPlayer musicPlayer, Point location){
        super(title);
        mp = musicPlayer;
        setLocation((int)location.getX()+50,(int)location.getX()+50);
        setSize(FRAME_X_SIZE,FRAME_Y_SIZE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        BGMLbl = new JLabel("Music Volume",SwingConstants.CENTER);
        BGMLbl.setBounds(25,25,FRAME_X_SIZE - 50,25);
        add(BGMLbl);

        BGMVolSlider = new JSlider();
        BGMVolSlider.setBounds(25,75,FRAME_X_SIZE - 50,25);
        BGMVolSlider.setPaintTicks(true);
        BGMVolSlider.setMajorTickSpacing(1);
        BGMVolSlider.setMaximum(10);
        BGMVolSlider.setMinimum(0);
        BGMVolSlider.setSnapToTicks(true);
        BGMVolSlider.setValue((int)(mp.getVolume() * 10f));
        BGMVolSlider.addChangeListener(new HandleBGMVolSliderChange());
        add(BGMVolSlider);
    }

    private class HandleBGMVolSliderChange implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            float newVolume = (float)BGMVolSlider.getValue() / 10f;
            mp.setVolume(newVolume);
        }
    }
}
