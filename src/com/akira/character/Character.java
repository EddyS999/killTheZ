package com.akira.character;

import com.akira.game.Main;

import javax.swing.*;
import java.awt.*;

public class Character {

    private int width, height;
    private int x,y;
    protected boolean walk;
    protected boolean right;
    public int count;
    protected boolean alive;
    public int deathCount;

    public Character(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.alive = true;
        this.deathCount = 0;

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isWalk() {
        return walk;
    }

    public void setWalk(boolean walk) {
        this.walk = walk;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }


    public boolean rightHitbox(Character character){
        if(this.isRight()){
            //En gros si les coordonnées d'un personnage != coordonnée d'un autre personnage
            // Retourne faux car il n'y a pas de contact
            if(this.getX() + this.getWidth() < character.getX() ||
                    this.getX() + this.getWidth() > character.getX() ||
                    this.getY() + this.getHeight() <= character.getY() ||
                    this.getY() >= character.getY() + character.getHeight()) {

                return false;
            }

            return true;
        }

        return false;

    }

    public boolean leftHitbox(Character character){

        if(!this.isRight()){
            if(this.getX() + this.getWidth() < character.getX() ||
                    this.getX() + this.getWidth() > character.getX() ||
                    this.getY() + this.getHeight() <= character.getY() ||
                    this.getY() >= character.getY() + character.getHeight()) {

                return false;
            } else
                return true;
        }

        return false;
    }
        //personnage entre en contact avec un autre personnage
        public boolean isCloseTo(Character character){
            if((this.getX() + this.getWidth() < character.getX() - 10 && this.getX() < character.getX() + character.getWidth()) ||
            (this.getX() + this.getWidth() > character.getX() - 10 && this.getX() + this.getWidth() < character.getX() + character.getWidth()+10)){
                return true;
            }
         return false;
        }

        public Image notMoving (String entity, int frequency){
        ImageIcon icon;
        Image img;
        String path;

        return null;

    }

    public Image Left(String name){
        Image img;
        String source = "";
        ImageIcon icon;
        if(!this.isRight())
            source = "/images/"+name+"/"+name+"_left.png";

        icon = new ImageIcon(getClass().getResource(source));
        img = icon.getImage();
        return img;
    }


    public Image running (String name, int frequency){
        ImageIcon icon;
        Image img;
        String path;


        return null;
    }


    //Algorithme qui permet de bouger un personnage lorsqu'il est sur place
    public Image moving(String name, int frequency){
        ImageIcon icon;
        Image img;
        String path = "";

        if(!this.isWalk() && this.isAlive()) {
           // this.count++;//on commence a compter

            if(this.isRight()){
                path = "/images/"+name+"/"+name+"_right.png";

            }
            else {
                path = "/images/"+name+"/"+name+"_left.png";
            }
            //Switch animation respiration 1
           /* if(this.count / frequency > 20){
                if(this.isRight()){
                    path = "/images/"+name+"/"+name+"_right_res.png";
                }
                path = "/images/"+name+"/"+name+"_left_res.png";
            }
            //Deuxieme switch respiration 2
            if(this.count / frequency > 30){
                if(this.isRight()){
                    path = "/images/"+name+"/"+name+"_right_res2.png";
                }
                path = "/images/"+name+"/"+name+"_left_res2.png";
            }

            if(this.count / frequency == 0){
                if(this.isRight()){
                    path = "/images/"+name+"/"+name+"_right.png";
                }
                path = "/images/"+name+"/"+name+"_left.png";
            }

            //Si le compteur franchi un certains nombre on le reset a 0
            if(this.count == 2 * frequency){
                this.count = 0;
            }
*/
        }
        icon = new ImageIcon(getClass().getResource(path));
        img = icon.getImage();
        return img;
    }
}



