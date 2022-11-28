package com.akira.character;

import javax.swing.*;
import java.awt.*;

public class Player extends Character{

    private Image imgPlayer;
    private ImageIcon iconPlayer;
    public int speed;
    public boolean shooting;

    public Player(int x, int y) {

        super(20, 40, x, y);
        super.setRight(true);
        super.setWalk(false);
        this.deathCount = 0;
        this.shooting = false;
        this.speed = 3;//vitesse de déplacement du joueur par défaut
        iconPlayer = new ImageIcon(getClass().getResource("/images/player/player_right.png"));//Position par défaut du joueur
        imgPlayer = iconPlayer.getImage();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    public void setShooting(boolean shooting){
        this.shooting = shooting;
    }

  public boolean isShooting(){
        return this.shooting;
  }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    public Image Right() {
        return imgPlayer;
    }


    //Algorithme qui permet d'animer un personnage lorsqu'il est sur place
    public Image moving(String name){
        ImageIcon icon;
        Image img;
        String path ="";
        int firstRound = 100;
        int secondRound = 150;
        int reset = 0;
        int limit = 200;

        if(!this.isWalk() && this.isAlive()) {
            this.count++;//on commence a compter
            if(this.count < firstRound){
                if(this.isRight()){
                    path = "/images/player/"+name+"_right.png";
                }
                else{
                    path = "/images/player/"+name+"_left.png";
                }
            }

            if(this.count > firstRound){
                if(this.isRight()){
                    path = "/images/player/"+name+"_right_res.png";
                }
                else
                    path = "/images/player/"+name+"_left_res.png";
            }


            if(this.count > secondRound){
                if(this.isRight()){
                    path = "/images/player/"+name+"_right_res2.png";
                }
                else
                    path = "/images/player/"+name+"_left_res2.png";
            }

            if(this.count > limit){
                count = reset;
            }

        }
        //Lorsque le personnage avance
        else if(this.isWalk() && this.isAlive()){
                //Lorsque le personnage court
            this.count++;

            if(this.count < firstRound){
                if(this.isRight()){
                    path = ""; //animation 1 droite
                }
                else {
                    path = ""; //animation 1 gauche
                }
            }

            if(this.count > firstRound){
                if(this.isRight()){
                    path = "";
                }
                else
                    path = "";
            }

        }

        icon = new ImageIcon(getClass().getResource(path));
        img = icon.getImage();
        return img;
    }


    public void setImgPlayer(Image imgPlayer) {
        this.imgPlayer = imgPlayer;
    }

    public ImageIcon getIconPlayer() {
        return iconPlayer;
    }

    public void setIconPlayer(ImageIcon iconPlayer) {
        this.iconPlayer = iconPlayer;
    }
}
