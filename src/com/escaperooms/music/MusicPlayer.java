package com.escaperooms.music;

import java.net.URL;
import javax.sound.sampled.*;


public class MusicPlayer extends Thread{
    String song;
    Clip clip;
    float volume = 0.5f;

    public MusicPlayer(String song) {
        this.song = song;
    }
    public MusicPlayer(String song, float volume) {
        this.song = song;
        try {
            setVolume(volume);
        }
        catch (IllegalArgumentException iae){
            volume = 0.5f;
        }
    }

    public void run() {
        try {
            URL url = MusicPlayer.class.getResource("/resources/" + song);
            AudioInputStream audioStream;
            audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(20f * (float)Math.log10(volume));
            /*
            while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
            {
            }
            */

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void playMusic(){
        if (clip != null && !clip.isActive()){
            clip.start();
        }
    }

    public void pauseMusic(){
        if (clip != null && clip.isActive()){
            clip.stop();
        }
    }

    public void stopMusic() {
        clip.stop();
        this.interrupt();
    }

    public void waitToDie() {
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Clip getClip() {
        return this.clip;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) throws IllegalArgumentException{
        if (volume < 0.0f || volume > 1.0f){
            throw new IllegalArgumentException("Volume must be a value of 0.0f - 1.0f inclusive.");
        }
        this.volume = volume;
        if (clip != null && clip.isActive()){
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(20f * (float)Math.log10(volume));
        }
    }

    float getClipVol() {
        if (clip != null) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            return (float) Math.pow(10f, volume.getValue() / 20f);
        }
        return -1.0f;
    }
}