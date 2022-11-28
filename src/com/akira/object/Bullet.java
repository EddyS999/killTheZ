package com.akira.object;

import com.akira.character.Player;

import javax.swing.*;

public class Bullet extends Obj {

    public boolean go;
    public int speed;
    private boolean right;
    public Bullet(int x, int y) {
        super(x, y, 10, 10);
        //On definit les image ici
        this.speed = 1;
        this.right = true;
        this.go = false;
        this.iconObject = new ImageIcon(getClass().getResource(""));
        this.imgObject = iconObject.getImage();
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public boolean isGo(){
        return this.go;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    public void move(){
        //deplacement a droite
        if(this.isGo() && this.isRight()){
            this.x = this.x + this.speed;
        }
        //deplacement a gauche
        else if(this.isGo() && !this.isRight()){
            this.x = this.x - this.speed;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);// Temps d'actualisation du mouvement
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
