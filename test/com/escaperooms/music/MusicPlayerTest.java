package com.escaperooms.music;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MusicPlayerTest {
    MusicPlayer mp;
    MusicPlayer mpWithVol;

    @Before
    public void createPlayer(){
        mp = new MusicPlayer("iwillbe.wav");
        mpWithVol = new MusicPlayer("iwillbe.wav",0.7f);
    }

    @Test
    public void oneArgConstructor_clipVolShouldBe_0_5f() {
        mp.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.5f,mp.getClipVol(),0.01);
        mp.stopMusic();
    }

    @Test
    public void twoArgConstructor_clipVolume_ShouldBe_0_7f() {
        mpWithVol.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.7f,mpWithVol.getClipVol(),0.01);
        mpWithVol.stopMusic();
    }

    @Test
    public void twoArgConstructor_invalidVolume_Neg0_1f_ShouldBe_0_5f() {
        MusicPlayer bad = new MusicPlayer("iwillbe.wav",-0.1f);
        bad.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.5f,bad.getClipVol(),0.01);
        bad.stopMusic();
    }

    @Test
    public void twoArgConstructor_invalidVolume_1_1f_ShouldBe_0_5f() {
        MusicPlayer bad = new MusicPlayer("iwillbe.wav",1.1f);
        bad.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.5f,bad.getClipVol(),0.01);
        bad.stopMusic();
    }

    @Test
    public void setVolumeTo_0_3F_shouldBe_0_3f() {
        mp.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.setVolume(0.3f);
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
    }

    @Test
    public void changeVolume_0_3f_ShouldBe_0_3F_whenResuming() {
        mp.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.setVolume(0.3f);
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.playMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
    }

    @Test (expected = IllegalArgumentException.class)
    public void changeVolume_IllegalVol_Neg_0_1f_ShouldThrowException() {
        mp.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.setVolume(-0.1f);
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.playMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
    }

    @Test (expected = IllegalArgumentException.class)
    public void changeVolume_IllegalVol_1_1f_ShouldThrowException() {
        mp.run();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.setVolume(1.1f);
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        mp.playMusic();
        try {Thread.sleep(50);}
        catch (InterruptedException e) {}
        assertEquals(0.3f,mp.getClipVol(),0.01f);
        assertEquals(0.3f,mp.getVolume(),0.01f);
        mp.stopMusic();
    }
}