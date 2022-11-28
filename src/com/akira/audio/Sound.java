package com.akira.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private Clip clip;

    public Sound(String sound){

        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(sound));
            clip = AudioSystem.getClip();
            clip.open(audio);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Clip getClip(){
        return clip;
    }

    public void play(){
        clip.start();
    }

    public void close(){
        clip.close();
    }

    public static void playSound(String sound){
        Sound s = new Sound(sound);
        s.play();
    }

    public static void closeSound(String sound){
        Sound s = new Sound(sound);
        s.close();
    }

}
