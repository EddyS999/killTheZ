package com.akira.character;

import java.awt.*;

public class Zombie extends Character implements Runnable{
    public Zombie(int x, int y) {
        super(20, 40, x, y);
    }




    //Moving
    public Image moving(String entity, int freq){
        super.moving(entity, freq);
        return null;
    }


    //Thread différent pour gérer l'animation des zombies indépendamment
    //du Thread principale
    @Override
    public void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
