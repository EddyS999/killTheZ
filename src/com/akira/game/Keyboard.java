package com.akira.game;


import com.akira.audio.Sound;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

            if(Main.mainWindow.player.isAlive()){
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    Main.mainWindow.player.setRight(true);
                    Main.mainWindow.player.setWalk(true);
                    Main.mainWindow.player.setX(Main.mainWindow.player.getX()+ Main.mainWindow.player.speed);//
                    //limite déplacement droite
                    if(Main.mainWindow.player.getX() > 664)
                        Main.mainWindow.player.setX(664);
              }

                // DEPLACEMENT VERS LA GAUCHE
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){

                    Main.mainWindow.player.setRight(false);
                    Main.mainWindow.player.setWalk(true);
                    Main.mainWindow.player.setX(Main.mainWindow.player.getX() - Main.mainWindow.player.speed);//
                    //Limite déplacement gauche
                    if(Main.mainWindow.player.getX() < 10){
                        Main.mainWindow.player.setX(10);
                    }

                }

                // LORQUE LE JOUEUR TIR ET QU'IL EST TOURNE VERS LA DROITE
                else if (e.getKeyCode() == KeyEvent.VK_SPACE && Main.mainWindow.player.isRight()){
                    Main.mainWindow.player.setShooting(true);
                    Main.mainWindow.bullet.setGo(true);
                    Main.mainWindow.bullet.setRight(true);
                    Main.mainWindow.bullet.setX(Main.mainWindow.player.getX());
                    Main.mainWindow.bullet.setY(Main.mainWindow.player.getY()+20);

                    //DEPLACEMENT DE LA BALLE

                    Sound.playSound("/audio/pistol.wav");

                }

                else if (e.getKeyCode() == KeyEvent.VK_SPACE && !Main.mainWindow.player.isRight()){
                    Main.mainWindow.player.setShooting(true);
                    Main.mainWindow.bullet.setGo(true);
                    Main.mainWindow.bullet.setRight(false);
                    Main.mainWindow.bullet.setX(Main.mainWindow.player.getX());
                    Main.mainWindow.bullet.setY(Main.mainWindow.player.getY()+20);
                    Sound.playSound("/audio/pistol.wav");
                }

            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.mainWindow.player.setX(Main.mainWindow.player.getX());
        Main.mainWindow.player.setWalk(false);
        //Main.mainWindow.player.setShooting(false);
    }
}
